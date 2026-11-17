
import { useActionState } from "react";
import api from "./api";

const PostForm = ({ onCreated }) => {

  const submitAction = async (prevState, formData) => {
    const title = formData.get("title")?.trim();
    const content = formData.get("content")?.trim();

    if (!title || !content) {
      return {
        error: "Please enter both title and content.",
        msg: "",
        title: title || "",
        content: content || "",
      };
    }

    try {
      await api.post("/posts", { title, content });

      await onCreated?.();

      return {
        error: null,
        msg: "Your post has been published successfully!",
        title: "",
        content: "",
      };

    } catch (error) {
      return {
        error:
          error.response?.data?.message ||
          error.response?.data?.error ||
          "Failed to publish your post. Please try again.",
        msg: "",
        title,
        content,
      };
    }
  };

  const [state, formAction, isPending] = useActionState(
    submitAction,
    {
      error: null,
      msg: "",
      title: "",
      content: "",
    }
  );

  return (
    <form action={formAction} className="post-form">

      <div className="post-input-group">
        <label htmlFor="title">POST TITLE</label>

        <input
          type="text"
          name="title"
          id="title"
          placeholder="Give your story an interesting title..."
          defaultValue={state.title}
          maxLength={150}
          required
          disabled={isPending}
        />
      </div>

      <div className="post-input-group">
        <label htmlFor="content">YOUR CONTENT</label>

        <textarea
          name="content"
          id="content"
          placeholder="What's on your mind? Share your ideas, experiences, or thoughts..."
          rows={5}
          defaultValue={state.content}
          required
          disabled={isPending}
        />
      </div>

      {state.error && (
        <div className="form-feedback error" role="alert">
          <span>!</span>
          {state.error}
        </div>
      )}

      {state.msg && (
        <div className="form-feedback success" role="status">
          <span>✓</span>
          {state.msg}
        </div>
      )}

      <div className="post-form-footer">
        <span className="editor-hint">
          ✨ Make your thoughts count.
        </span>

        <button
          type="submit"
          className="publish-btn"
          disabled={isPending}
        >
          {isPending ? (
            <>
              <span className="button-spinner"></span>
              Publishing...
            </>
          ) : (
            <>
              Publish Post <span>↗</span>
            </>
          )}
        </button>
      </div>

    </form>
  );
};

export default PostForm;
