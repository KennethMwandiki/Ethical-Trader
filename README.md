# Ethical Trader - Compliance-as-a-Service (CaaS)

Ethical Trader is a multi-tenant, cloud-native Compliance-as-a-Service platform designed for cross-border trade compliance. It features modular microservices for compliance rules, monitoring, policy-as-code, auto-remediation, and integration with external systems.

## Contents
- `backend/` - Java Spring Boot microservices
- `api-gateway/` - API gateway configuration
- `frontend/` - Static HTML/CSS dashboard
- `infra/` - Kubernetes manifests and configs
- `docs/` - Deployment and design docs

## Quick start (local)
1. Start PostgreSQL and set connection values in `infra/k8s-configmap.yaml` or service `application.yml` files.
2. Build and run each service locally with Maven:

```pwsh
cd backend/compliance-service
./mvnw spring-boot:run
# Repeat for other services
```

3. Open `frontend/index.html` in a browser and point API requests to the running services (or use the API gateway).

## Deployment
See `docs/DEPLOYMENT.md` for Kubernetes-based deployment and multi-region guidance.

## CI/CD
A GitHub Actions workflow is included to build and push images and deploy to Kubernetes (configure secrets for container registry and kubeconfig).

## Security
All APIs enforce OAuth2/JWT resource-server validation; configure `security.jwt.secret` in env or `infra/k8s-configmap.yaml`.

## Contributing
- Use feature branches and open PRs against `main`.
- Run unit tests and linters before PR.

---

© 2025 Ethical Trader. All Rights Reserved.