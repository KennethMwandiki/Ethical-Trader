## How to publish this repository to GitHub

This guide shows how to push the current workspace to
`https://github.com/KennethMwandiki/Ethical-Trader` from your local machine.

Prerequisites
- Git installed and configured with your `user.name` and `user.email`.
- A GitHub account and either:
  - SSH keys configured on GitHub (recommended), or
  - a Personal Access Token (PAT) with `repo` scope for HTTPS pushes.

Quick steps (PowerShell)

1) Initialize the repo (run once)

```pwsh
cd 'C:\Users\User\Documents\Ethical Trader'
if (-not (Test-Path .git)) {
  git init
  git add .
  git commit -m 'Initial commit - Ethical Trader platform'
} else {
  Write-Host 'Repository already initialized.'
}
```

2) Add a remote and push

Recommended (SSH):

```pwsh
git remote add origin git@github.com:KennethMwandiki/Ethical-Trader.git
git branch -M main
git push -u origin main
```

If you must use HTTPS with a PAT (avoid embedding PAT in remote URL):

```pwsh
# Set the remote to the repo URL (no PAT embedded)
git remote add origin https://github.com/KennethMwandiki/Ethical-Trader.git
git branch -M main
# When prompted for credentials, provide username and PAT
git push -u origin main
```

3) Use the helper script (optional)

The helper script `scripts/publish.ps1` can automate initialization and push. It is designed to avoid permanently storing PATs in the remote URL. Example (PowerShell):

```pwsh
# Use SSH (recommended)
.\scripts\publish.ps1 -UseSsh

# Use HTTPS (the script will prompt for a PAT temporarily and use it for the push)
.\scripts\publish.ps1 -UseSsh:$false
```

4) After push: configure GitHub repository secrets (Repository -> Settings -> Secrets and variables -> Actions):
- `REGISTRY` — container registry prefix (e.g. `ghcr.io/your-org` or `docker.io/your-org`)
- `DOCKER_USERNAME` and `DOCKER_PASSWORD` — for registry login (or configure OIDC)
- `KUBE_CONFIG` — base64-encoded kubeconfig (used by CI deploy job)

5) Recommended repository protection
- Enable branch protection for `main` and require PR reviews and CI checks before merging.

Security notes
- Never commit secrets into the repository. Use GitHub Secrets for CI and deployment credentials.

---

If you want, I can convert the `scripts/publish.ps1` to use the GitHub CLI (`gh`) for creating the repo and pushing (requires `gh` configured). Tell me which flow you prefer (SSH vs. GH CLI) and I will update the script.