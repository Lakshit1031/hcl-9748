import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import Home from './Component/Home'
import Login from './Component/Login'
import Registration from './Component/Registration'
import Dashboard from './Component/Dashboard'
import './App.css'

export default function App() {
  return <BrowserRouter><Routes>
    <Route path="/" element={<Home />} />
    <Route path="/login" element={<Login />} />
    <Route path="/registration" element={<Registration />} />
    <Route path="/dashboard" element={<Dashboard />} />
    <Route path="*" element={<Navigate to="/" replace />} />
  </Routes></BrowserRouter>
}
