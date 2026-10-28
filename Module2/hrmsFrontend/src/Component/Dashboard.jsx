import { useEffect, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom'
import { api } from '../api'

const dateKey = () => new Intl.DateTimeFormat('en-CA', { timeZone: 'Asia/Kolkata', year: 'numeric', month: '2-digit', day: '2-digit' }).format(new Date())
const niceDate = value => new Date(`${value}T12:00:00`).toLocaleDateString('en-IN', { day: 'numeric', month: 'short', year: 'numeric' })
const niceTime = value => value ? new Date(`${value}+05:30`).toLocaleTimeString('en-IN', { timeZone: 'Asia/Kolkata', hour: '2-digit', minute: '2-digit' }) : '—'

export default function Dashboard() {
  const navigate = useNavigate()
  const [user, setUser] = useState(null)
  const [records, setRecords] = useState([])
  const [loading, setLoading] = useState(true)
  const [busy, setBusy] = useState(false)
  const [error, setError] = useState('')
  useEffect(() => {
    let active = true
    Promise.all([api('/v1/user/me'), api('/v1/user/attendance')]).then(([employee, history]) => {
      if (active) { setUser(employee); setRecords(history) }
    }).catch(e => { if (active) { if (e.message === 'Please sign in again.' || e.message === 'Please sign in') navigate('/login', { replace: true }); else setError(e.message) } })
      .finally(() => { if (active) setLoading(false) })
    return () => { active = false }
  }, [navigate])
  async function mark(action) {
    setBusy(true); setError('')
    try {
      await api(`/v1/user/attendance/${action}`, { method: 'POST' })
      setRecords(await api('/v1/user/attendance'))
    } catch (e) { setError(e.message) } finally { setBusy(false) }
  }
  async function logout() {
    try { await api('/v1/user/logout', { method: 'POST' }) } finally { navigate('/login', { replace: true }) }
  }
  if (loading) return <div className="loading">Loading your workspace…</div>
  if (!user) return <main className="loading"><p>{error}</p><Link to="/login">Back to sign in</Link></main>
  const today = records.find(row => row.attendanceDate === dateKey())
  const month = dateKey().slice(0, 7)
  const days = records.filter(row => row.attendanceDate.startsWith(month)).length
  return <div className="dashboard"><aside className="sidebar"><Link className="brand light" to="/">● <span>people<span className="brand-accent">flow</span></span></Link><div className="side-label">WORKSPACE</div><div className="side-active">▦ &nbsp; Overview</div><div className="side-caption">Your daily attendance, all in one place.</div><div className="side-bottom"><div className="avatar">{user.emp_name?.[0]?.toUpperCase()}</div><div><strong>{user.emp_name}</strong><small>Employee #{user.emp_id}</small></div></div></aside>
    <main className="dash-main"><header className="dash-header"><div><span className="eyebrow">EMPLOYEE WORKSPACE</span><h1>Good {new Date().getHours() < 12 ? 'morning' : new Date().getHours() < 17 ? 'afternoon' : 'evening'}, {user.emp_name?.split(' ')[0]}.</h1><p>Here’s what your workday looks like.</p></div><button className="text-button" onClick={logout}>Sign out ↗</button></header>
      {error && <p className="error" role="alert">{error}</p>}
      <div className="stats"><article className="stat"><span className="stat-icon">◷</span><span className="stat-label">TODAY’S STATUS</span><strong>{today ? today.outTime ? 'Completed' : 'Checked in' : 'Not checked in'}</strong><small>{today ? 'Your attendance is recorded' : 'Ready when you are'}</small></article><article className="stat"><span className="stat-icon peach">▦</span><span className="stat-label">DAYS THIS MONTH</span><strong>{days.toString().padStart(2, '0')}</strong><small>Attendance records this month</small></article><article className="stat"><span className="stat-icon blue">✧</span><span className="stat-label">EMPLOYEE ID</span><strong>#{user.emp_id}</strong><small>{user.designation || 'Team member'}</small></article></div>
      <div className="content-grid"><section className="panel checkin"><span className="eyebrow">TODAY · {niceDate(dateKey()).toUpperCase()}</span><h2>Make today count.</h2><p>{!today ? 'Start your day by checking in. Your attendance will be saved automatically.' : today.outTime ? 'All done for today. See you next time!' : 'You’re checked in. Remember to check out at the end of your day.'}</p><div className="check-time"><div><span>CHECK IN</span><strong>{niceTime(today?.inTime)}</strong></div><div><span>CHECK OUT</span><strong>{niceTime(today?.outTime)}</strong></div></div>{!today ? <button className="primary" disabled={busy} onClick={() => mark('mark')}>{busy ? 'Saving…' : 'Check in now →'}</button> : !today.outTime ? <button className="primary" disabled={busy} onClick={() => mark('checkout')}>{busy ? 'Saving…' : 'Check out →'}</button> : <span className="done">✓ Day completed</span>}</section>
      <section className="panel profile"><span className="eyebrow">YOUR PROFILE</span><div className="profile-avatar">{user.emp_name?.[0]?.toUpperCase()}</div><h2>{user.emp_name}</h2><p>{user.designation || 'Team member'}</p><div className="profile-lines"><div><span>TEAM / STACK</span><strong>{user.stack || '—'}</strong></div><div><span>EMAIL</span><strong>{user.email}</strong></div></div></section></div>
      <section className="panel history"><div className="history-head"><div><span className="eyebrow">YOUR RECORD</span><h2>Attendance history</h2></div><span className="record-count">{records.length} records</span></div>{records.length ? <div className="table-wrap"><table><thead><tr><th>DATE</th><th>CHECK IN</th><th>CHECK OUT</th><th>STATUS</th></tr></thead><tbody>{records.map(row => <tr key={row.attendanceId}><td>{niceDate(row.attendanceDate)}</td><td>{niceTime(row.inTime)}</td><td>{niceTime(row.outTime)}</td><td><span className="badge">{row.outTime ? 'Completed' : 'Checked in'}</span></td></tr>)}</tbody></table></div> : <p className="empty">No attendance yet. Your check ins will appear here.</p>}</section>
    </main></div>
}
