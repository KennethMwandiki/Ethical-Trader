param(
    [switch]$UseSsh = $true
)

$repoPath = "c:\Users\User\Documents\Ethical Trader"
Set-Location -Path $repoPath

function Ensure-RepoInitialized {
    if (-not (Test-Path .git)) {
        git init
        git add .
        git commit -m "Initial commit - Ethical Trader platform"
    } else {
        Write-Host "Git repo already initialized"
    }
}

Ensure-RepoInitialized

if ($UseSsh) {
    Write-Host "Using SSH remote flow (recommended)."
    $origin = git remote get-url origin 2>$null
    if (-not $origin) {
        git remote add origin git@github.com:KennethMwandiki/Ethical-Trader.git
        Write-Host "Added SSH remote 'origin'."
    } else {
        Write-Host "Remote 'origin' already exists: $origin"
    }

    git branch -M main
    git push -u origin main
} else {
    Write-Host "Using HTTPS flow. You will be prompted for GitHub username and a Personal Access Token (PAT)."
    $username = Read-Host "GitHub username"
    $securePat = Read-Host "Personal Access Token (PAT)" -AsSecureString
    $ptr = [System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($securePat)
    $plainPat = [System.Runtime.InteropServices.Marshal]::PtrToStringAuto($ptr)
    [System.Runtime.InteropServices.Marshal]::ZeroFreeBSTR($ptr)

    # Use an ephemeral push URL; do not persist PAT in git config
    $pushUrl = "https://$username:$plainPat@github.com/KennethMwandiki/Ethical-Trader.git"
    git branch -M main
    Write-Host "Pushing to repository (ephemeral credentials)."
    git push $pushUrl main -u

    # Wipe the plain token from memory
    $plainPat = ""
}

Write-Host "Done. If the push succeeded, configure repository secrets (REGISTRY, DOCKER_USERNAME, DOCKER_PASSWORD, KUBE_CONFIG) in GitHub Settings -> Secrets." 
