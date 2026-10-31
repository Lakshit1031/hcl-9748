
import React from "react";
import AuthForm from "./AuthForm";
import PostForm from "./PostForm";

const App = () => {
  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-950 via-indigo-950 to-purple-950 px-4 py-12">

      {/* Header */}
      <header className="mx-auto mb-12 max-w-5xl text-center">
        <h1 className="text-4xl font-extrabold tracking-tight text-white sm:text-5xl">
          Post<span className="text-purple-400">Sphere</span>
        </h1>

        <p className="mt-4 text-lg text-gray-300">
          Share your thoughts. Connect with people. Inspire the world.
        </p>
      </header>

      {/* Main Content */}
      <main className="mx-auto grid max-w-5xl grid-cols-1 gap-8 md:grid-cols-2">

        {/* Authentication Card */}
        <section className="rounded-3xl border border-white/10 bg-white/10 p-8 shadow-2xl backdrop-blur-xl transition duration-300 hover:bg-white/15 sm:p-10">
          <div className="mb-8 text-center">
            <div className="mb-4 text-5xl">👋</div>

            <h2 className="text-2xl font-bold text-white">
              Welcome Back
            </h2>

            <p className="mt-2 text-sm text-gray-400">
              Login or register to join our community.
            </p>
          </div>

          <AuthForm />
        </section>

        {/* Create Post Card */}
        <section className="rounded-3xl border border-white/10 bg-white/10 p-8 shadow-2xl backdrop-blur-xl transition duration-300 hover:bg-white/15 sm:p-10">
          <div className="mb-8 text-center">
            <div className="mb-4 text-5xl">✍️</div>

            <h2 className="text-2xl font-bold text-white">
              Create a Post
            </h2>

            <p className="mt-2 text-sm text-gray-400">
              Share your ideas and thoughts with everyone.
            </p>
          </div>

          <PostForm />
        </section>

      </main>

      {/* Footer */}
      <footer className="mt-16 text-center text-sm text-gray-500">
        Built with <span className="font-semibold text-purple-400">React</span> &
        <span className="font-semibold text-cyan-400"> Tailwind CSS</span>
      </footer>

    </div>
  );
};

export default App;
