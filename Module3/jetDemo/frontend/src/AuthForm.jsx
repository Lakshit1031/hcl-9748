
import { useState } from "react";
import api from "./api";
import "./AuthForm.css";

const AuthForm = ({ onLogin }) => {
  const [mode, setMode] = useState("login");

  const [formData, setFormData] = useState({
    username: "",
    password: "",
  });

  const [showPassword, setShowPassword] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  const [message, setMessage] = useState({
    type: "",
    text: "",
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    setFormData((prev) => ({
      ...prev,
      [name]: value,
    }));

    setMessage({ type: "", text: "" });
  };

  const switchMode = () => {
    setMode((prev) =>
      prev === "login" ? "register" : "login"
    );

    setMessage({ type: "", text: "" });
    setShowPassword(false);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const username = formData.username.trim();
    const password = formData.password;

    if (!username || !password.trim()) {
      setMessage({
        type: "error",
        text: "Please enter both username and password.",
      });
      return;
    }

    if (username.length < 3) {
      setMessage({
        type: "error",
        text: "Username must contain at least 3 characters.",
      });
      return;
    }

    if (password.length < 6) {
      setMessage({
        type: "error",
        text: "Password must contain at least 6 characters.",
      });
      return;
    }

    setIsLoading(true);
    setMessage({ type: "", text: "" });

    try {
      if (mode === "register") {
        const response = await api.post("/auth/register", {
          username,
          password,
        });

        setMessage({
          type: "success",
          text:
            response.data.message ||
            "Account created successfully. Please login.",
        });

        setMode("login");

        setFormData({
          username,
          password: "",
        });
      } else {
        const response = await api.post("/auth/login", {
          username,
          password,
        });

        const { token, username: loggedInUser } = response.data;

        if (!token || !loggedInUser) {
          throw new Error("Invalid authentication response.");
        }

        // Save JWT token
        localStorage.setItem("token", token);
        localStorage.setItem("username", loggedInUser);

        // Notify parent component
        onLogin(loggedInUser);
      }
    } catch (error) {
      const errorMessage =
        error.response?.data?.message ||
        error.response?.data?.detail ||
        error.response?.data?.error ||
        error.message ||
        "Something went wrong. Please try again.";

      setMessage({
        type: "error",
        text: errorMessage,
      });
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="auth-wrapper">
      <div className="auth-card">

        {/* Header */}
        <div className="auth-header">
          <div className="auth-logo">
            <span>J</span>
          </div>

          <h1>
            {mode === "login"
              ? "Welcome Back!"
              : "Create Account"}
          </h1>

          <p>
            {mode === "login"
              ? "Login to access your account and share your thoughts."
              : "Join our community and start sharing your thoughts."}
          </p>
        </div>

        {/* Form */}
        <form onSubmit={handleSubmit} className="auth-form">

          <div className="form-group">
            <label htmlFor="username">Username</label>

            <input
              type="text"
              id="username"
              name="username"
              placeholder="Enter your username"
              value={formData.username}
              onChange={handleChange}
              autoComplete="username"
              required
              disabled={isLoading}
            />
          </div>

          <div className="form-group">
            <label htmlFor="password">Password</label>

            <div className="password-wrapper">
              <input
                type={showPassword ? "text" : "password"}
                id="password"
                name="password"
                placeholder="Enter your password"
                value={formData.password}
                onChange={handleChange}
                autoComplete={
                  mode === "login"
                    ? "current-password"
                    : "new-password"
                }
                required
                disabled={isLoading}
              />

              <button
                type="button"
                className="password-toggle"
                onClick={() =>
                  setShowPassword((prev) => !prev)
                }
                disabled={isLoading}
              >
                {showPassword ? "Hide" : "Show"}
              </button>
            </div>
          </div>

          {/* Feedback */}
          {message.text && (
            <div
              className={`auth-message ${message.type}`}
              role={message.type === "error" ? "alert" : "status"}
            >
              {message.text}
            </div>
          )}

          {/* Submit */}
          <button
            type="submit"
            className="auth-submit"
            disabled={isLoading}
          >
            {isLoading ? (
              <>
                <span className="auth-spinner"></span>
                Please wait...
              </>
            ) : mode === "login" ? (
              "Login"
            ) : (
              "Create Account"
            )}
          </button>
        </form>

        {/* Switch Mode */}
        <div className="auth-footer">
          <p>
            {mode === "login"
              ? "Don't have an account?"
              : "Already have an account?"}

            <button
              type="button"
              onClick={switchMode}
              disabled={isLoading}
            >
              {mode === "login" ? "Register" : "Login"}
            </button>
          </p>
        </div>

        {/* Security Info */}
        <div className="auth-security">
          <span>🔒</span>
          Secure authentication powered by JWT
        </div>

      </div>
    </div>
  );
};

export default AuthForm;
