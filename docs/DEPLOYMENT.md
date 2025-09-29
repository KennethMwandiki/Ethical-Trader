# Ethical Trader Platform Deployment Guide

## Prerequisites
- Docker and Docker Compose installed
- Kubernetes cluster(s) (AKS, EKS, GKE, or local Minikube)
- kubectl configured for your cluster(s)
- Helm (optional, for advanced deployments)
- PostgreSQL instance (cloud or self-hosted)
- (Optional) Terraform/Bicep for multi-cloud provisioning

---

## 1. Build Docker Images

Run the following commands in the project root to build all microservices:

```sh
# Compliance Service
cd backend/compliance-service
# If the Maven wrapper is present (recommended):
./mvnw clean package
# If mvnw is not present, generate it locally using your system Maven:
# mvn -N io.takari:maven:wrapper
# or use system Maven: mvn clean package
# Build Docker image
sudo docker build -t compliance-service:latest .

# Repeat for each service:
cd ../monitoring-service
./mvnw clean package
sudo docker build -t monitoring-service:latest .

cd ../rules-engine
./mvnw clean package
sudo docker build -t rules-engine:latest .

cd ../auto-remediation-service
./mvnw clean package
sudo docker build -t auto-remediation-service:latest .

cd ../integration-service
./mvnw clean package
sudo docker build -t integration-service:latest .

# API Gateway
cd ../../../api-gateway
sudo docker build -t api-gateway:latest .
```

---

## 2. Push Images to Registry (Optional)

If deploying to cloud, tag and push images to your registry (e.g., Azure Container Registry, Docker Hub):

```sh
docker tag compliance-service <your-registry>/compliance-service:latest
docker push <your-registry>/compliance-service:latest
# Repeat for all images
```

---

## 3. Configure Environment

- Update `infra/k8s-configmap.yaml` with your database credentials and JWT secret.
- Set region-specific values as needed for multi-region deployments.

---

## 4. Deploy to Kubernetes

Apply manifests in the `infra/` directory:

```sh
kubectl apply -f infra/k8s-configmap.yaml
kubectl apply -f infra/k8s-deployment.yaml
kubectl apply -f infra/k8s-ingress.yaml

CI note: The GitHub Actions workflow now runs unit tests (`mvn test`) for each backend service before packaging. The workflow prefers the repository `mvnw` wrapper when present; if the wrapper is missing it falls back to the system `mvn`. To ensure consistent builds across contributors and CI, generate and commit the Maven wrapper locally (run `mvn -N io.takari:maven:wrapper`) and commit the resulting `.mvn/wrapper/maven-wrapper.jar` and wrapper scripts.
```

---

## 5. Verify Deployment

Check pods and services:

```sh
kubectl get pods
kubectl get services
kubectl get ingress
```

Access the platform via the configured ingress host (e.g., http://ethicaltrader.local).

---

## 6. Multi-Region/Cloud Deployment (Optional)

- Use Terraform/Bicep scripts to provision clusters in multiple regions/clouds.
- Deploy the same manifests to each cluster.
- Configure DNS and API gateway for geo-routing and failover.

---

## 7. CI/CD Pipeline (Optional)

- Use GitHub Actions or Azure DevOps to automate build, test, and deployment.
- Example workflow: on push to main, build images, push to registry, and deploy to Kubernetes.

---

## 8. Monitoring & Logs

- Integrate with ELK stack, Azure Monitor, or similar for centralized logging.
- Use Prometheus/Grafana for metrics and dashboards.

---

## 9. Rollback & Updates

- To update a service, build and push the new image, then run:

```sh
kubectl rollout restart deployment/<deployment-name>
```

---

For advanced scenarios (multi-cloud, edge, AI integration), see the roadmap in the main documentation.
