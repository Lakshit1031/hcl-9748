import { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { api } from '../api'

export default function Registration() {
  const navigate = useNavigate()
  const [form, setForm] = useState({ emp_id: '', emp_name: '', designation: '', stack: '', email: '', password: '' })
  const [error, setError] = useState('')
  const [busy, setBusy] = useState(false)
  function change(event) { setForm({ ...form, [event.target.name]: event.target.value }) }
  async function submit(event) {
    event.preventDefault(); setError(''); setBusy(true)
    try {
      await api('/v1/user/register', { method: 'POST', body: JSON.stringify({ ...form, emp_id: Number(form.emp_id) }) })
      navigate('/dashboard', { replace: true })
    } catch (e) { setError(e.message) } finally { setBusy(false) }
  }
  return <main className="auth-layout">
    <section className="auth-aside"><Link className="brand light" to="/">● <span>people<span className="brand-accent">flow</span></span></Link><div><span className="eyebrow">A BETTER WAY TO WORK</span><h1>Your day, all in one place.</h1><p>Create your profile, check in each day, and keep your attendance in view.</p></div><small>PEOPLEFLOW · HRMS</small></section>
    <section className="auth-panel"><div className="auth-card"><span className="eyebrow">GET STARTED</span><h2>Create your account</h2><p className="subtle">A few details and your workspace is ready.</p><form onSubmit={submit} className="register-grid">
      <div><label htmlFor="emp_name">Full name</label><input id="emp_name" name="emp_name" value={form.emp_name} onChange={change} required placeholder="Your name" /></div>
      <div><label htmlFor="emp_id">Employee ID</label><input id="emp_id" name="emp_id" type="number" min="1" value={form.emp_id} onChange={change} required placeholder="e.g. 1001" /></div>
      <div><label htmlFor="designation">Designation</label><input id="designation" name="designation" value={form.designation} onChange={change} placeholder="e.g. Developer" /></div>
      <div><label htmlFor="stack">Team / stack</label><input id="stack" name="stack" value={form.stack} onChange={change} placeholder="e.g. Engineering" /></div>
      <div className="span-2"><label htmlFor="email">Work email</label><input id="email" name="email" type="email" value={form.email} onChange={change} required placeholder="you@company.com" /></div>
      <div className="span-2"><label htmlFor="reg-password">Password</label><input id="reg-password" name="password" type="password" minLength="8" value={form.password} onChange={change} required placeholder="At least 8 characters" /></div>
      {error && <p className="error span-2" role="alert">{error}</p>}<button className="primary full span-2" disabled={busy}>{busy ? 'Creating account…' : 'Create account →'}</button>
    </form><p className="auth-switch">Already have an account? <Link to="/login">Sign in</Link></p></div></section>
  </main>
}
