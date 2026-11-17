
import { useCallback, useEffect, useState } from "react";
import api from "./api";
import AuthForm from "./AuthForm";
import PostForm from "./PostForm";
import "./App.css";

const App = () => {
  const [user, setUser] = useState(
    localStorage.getItem("username")
  );

  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const loadPosts = useCallback(async () => {
    try {
      setError("");
      const { data } = await api.get("/posts");
      setPosts(Array.isArray(data) ? data : []);
    } catch (err) {
      setError(
        err.response?.data?.message ||
        "Unable to load posts. Please try again."
      );
    } finally {
      setLoading(false);
    }
  }, []);

  useEffect(() => {
    loadPosts();
  }, [loadPosts]);

  const handleLogin = (username) => {
    setUser(username);
    loadPosts();
  };

  const logout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    setUser(null);
  };

  return (
    <div className="app-container">

      {/* Navigation */}
      <header className="navbar">
        <div className="navbar-inner">

          <a href="/" className="brand">
            <span className="brand-icon">J</span>
            <span>JWT<span className="brand-highlight">Blog</span></span>
          </a>

          <div className="navbar-right">
            {user ? (
              <>
                <div className="user-profile">
                  <div className="user-avatar">
                    {user.charAt(0).toUpperCase()}
                  </div>
                  <span>{user}</span>
                </div>

                <button
                  className="logout-btn"
                  onClick={logout}
                >
                  Logout <span>↗</span>
                </button>
              </>
            ) : (
              <span className="nav-caption">
                Share your thoughts
              </span>
            )}
          </div>

        </div>
      </header>

      <main className="main-content">

        {/* Hero Section */}
        <section className="hero-section">
          <div className="hero-label">
            <span className="live-dot"></span>
            YOUR SPACE TO WRITE
          </div>

          <h1>
            Ideas worth <span>sharing.</span>
          </h1>

          <p>
            Write, publish, and discover interesting thoughts
            from your community.
          </p>
        </section>

        {/* Authentication */}
        {!user ? (
          <section className="auth-section">
            <AuthForm onLogin={handleLogin} />
          </section>
        ) : (
          <>
            {/* Welcome */}
            <section className="welcome-section">
              <div>
                <p className="welcome-eyebrow">
                  YOUR DASHBOARD
                </p>
                <h2>
                  Welcome back, {user}!
                </h2>
                <p>
                  Ready to share something interesting today?
                </p>
              </div>

              <div className="welcome-icon">✍️</div>
            </section>

            {/* Create Post */}
            <section className="editor-section">
              <div className="section-heading">
                <div>
                  <span className="section-number">01</span>
                  <h2>Create something new</h2>
                </div>
                <span className="section-subtitle">
                  YOUR NEXT STORY STARTS HERE
                </span>
              </div>

              <PostForm onCreated={loadPosts} />
            </section>
          </>
        )}

        {/* Posts */}
        <section className="posts-section">

          <div className="section-heading">
            <div>
              <span className="section-number">02</span>
              <h2>Explore posts</h2>
            </div>

            <span className="post-count">
              {posts.length} {posts.length === 1 ? "POST" : "POSTS"}
            </span>
          </div>

          {error && (
            <div className="app-error" role="alert">
              {error}
              <button onClick={loadPosts}>Retry</button>
            </div>
          )}

          {loading ? (
            <div className="empty-state">
              <div className="loading-spinner"></div>
              <p>Loading stories...</p>
            </div>
          ) : posts.length === 0 ? (
            <div className="empty-state">
              <div className="empty-icon">📝</div>
              <h3>No stories published yet</h3>
              <p>
                Be the first to share an idea with the community.
              </p>
            </div>
          ) : (
            <div className="posts-grid">
              {posts.map((post) => (
                <article className="post-card" key={post.id}>
                  <div className="post-card-top">
                    <span className="post-tag">COMMUNITY STORY</span>
                    <span className="post-symbol">✦</span>
                  </div>

                  <h3>{post.title}</h3>

                  <p className="post-content">
                    {post.content}
                  </p>

                  <div className="post-divider"></div>

                  <div className="post-meta">
                    <div className="post-author">
                      <div className="author-avatar">
                        {post.author?.charAt(0).toUpperCase() || "U"}
                      </div>

                      <div>
                        <strong>{post.author || "Unknown"}</strong>
                        <span>Author</span>
                      </div>
                    </div>

                    <time dateTime={post.createdAt}>
                      {post.createdAt
                        ? new Date(post.createdAt).toLocaleDateString()
                        : ""}
                    </time>
                  </div>
                </article>
              ))}
            </div>
          )}

        </section>

      </main>

      {/* Footer */}
      <footer className="app-footer">
        <p>JWT Blog © 2026</p>
        <span>Built with React & Spring Boot</span>
      </footer>

    </div>
  );
};

export default App;
