import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { api } from '../api'

export default function Login() {
  const navigate = useNavigate()
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [busy, setBusy] = useState(false)
  async function submit(event) {
    event.preventDefault(); setError(''); setBusy(true)
    try {
      await api('/v1/user/login', { method: 'POST', body: JSON.stringify({ emp_id: Number(id), password }) })
      navigate('/dashboard', { replace: true })
    } catch (e) { setError(e.message) } finally { setBusy(false) }
  }
  return <main className="auth-layout">
    <section className="auth-aside"><Link className="brand light" to="/">● <span>people<span className="brand-accent">flow</span></span></Link><div><span className="eyebrow">YOUR WORKDAY, SIMPLIFIED</span><h1>Good work starts with a good day.</h1><p>Stay on top of your attendance with a simple workspace built around your day.</p></div><small>PEOPLEFLOW · HRMS</small></section>
    <section className="auth-panel"><div className="auth-card"><span className="eyebrow">WELCOME BACK</span><h2>Sign in to your workspace</h2><p className="subtle">Enter your employee ID and password to continue.</p><form onSubmit={submit}>
      <label htmlFor="empId">Employee ID</label><input id="empId" inputMode="numeric" type="number" min="1" required value={id} onChange={e => setId(e.target.value)} placeholder="e.g. 1001" />
      <label htmlFor="password">Password</label><input id="password" type="password" required value={password} onChange={e => setPassword(e.target.value)} placeholder="Enter your password" />
      {error && <p className="error" role="alert">{error}</p>}<button className="primary full" disabled={busy}>{busy ? 'Signing in…' : 'Sign in →'}</button>
    </form><p className="auth-switch">New here? <Link to="/registration">Create an account</Link></p></div></section>
  </main>
}
