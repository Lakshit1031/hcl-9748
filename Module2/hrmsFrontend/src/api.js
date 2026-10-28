export async function api(path, options = {}) {
  let response
  try {
    response = await fetch(`/api${path}`, {
      credentials: 'same-origin',
      ...options,
      headers: { ...(options.body ? { 'Content-Type': 'application/json' } : {}), ...options.headers },
    })
  } catch {
    throw new Error('Cannot reach the server. Check that the backend is running on port 8080.')
  }
  const data = await response.json().catch(() => null)
  if (!response.ok) {
    throw new Error(data?.message || data?.detail || (response.status === 401 ? 'Please sign in again.' : `Request failed (${response.status}).`))
  }
  return data
}
