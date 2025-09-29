// Dashboard logic for Ethical Trader

async function fetchData(endpoint) {
	const response = await fetch(endpoint, {
		headers: {
			// Add JWT token here for production
			'Content-Type': 'application/json'
		}
	});
	return response.json();
}

async function loadDashboard() {
	// Fetch compliance rules
	const rules = await fetchData('/api/compliance/rules');
	const alerts = await fetchData('/api/monitoring/alerts');
	const remediations = await fetchData('/api/remediation/actions');
	const integrations = await fetchData('/api/integration/configs');

	document.getElementById('dashboard-content').innerHTML = `
		<h3>Compliance Rules</h3>
		<ul>${rules.map(r => `<li>${r.region}: ${r.regulation} - ${r.description}</li>`).join('')}</ul>
		<h3>Active Alerts</h3>
		<ul>${alerts.map(a => `<li>${a.type} [${a.severity}]: ${a.message}</li>`).join('')}</ul>
		<h3>Remediation Actions</h3>
		<ul>${remediations.map(r => `<li>${r.violationType}: ${r.action} [${r.status}]</li>`).join('')}</ul>
		<h3>Integrations</h3>
		<ul>${integrations.map(i => `<li>${i.name}: ${i.apiUrl}</li>`).join('')}</ul>
	`;
}

document.addEventListener('DOMContentLoaded', loadDashboard);
