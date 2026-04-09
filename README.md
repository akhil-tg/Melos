# ✨ Melos

> A powerful monorepo tool for managing multi-package Dart and Flutter projects with ease.

## 🚀 Overview

Melos is a comprehensive solution for managing complex multi-package repositories. It streamlines workflows, automates repetitive tasks, and provides developers with an intuitive CLI for building and maintaining scalable projects.

Whether you're working with a small suite of packages or a large-scale monorepo, Melos handles dependency management, versioning, publishing, and scripting with elegance.

---

## ✨ Key Features

- ���� **Multi-Package Management** - Organize and manage multiple packages in a single repository
- 🔗 **Smart Dependency Resolution** - Automatically handle inter-package dependencies
- 📈 **Semantic Versioning** - Manage versions across all packages with ease
- 🎯 **Custom Scripts** - Run commands across packages simultaneously
- 🚀 **Easy Publishing** - Publish packages to pub.dev with a single command
- 🛠️ **Developer Friendly** - Intuitive CLI with helpful command guidance
- 📝 **Changelog Generation** - Auto-generate changelogs from git history

---

## 🎯 Quick Start

### Installation

```bash
dart pub global activate melos
```

### Initialize Your Repository

```bash
melos init
```

Create a `melos.yaml` file in your repository root:

```yaml
name: my_monorepo
repository: https://github.com/myusername/my_monorepo

packages:
  - packages/**
```

### Common Commands

```bash
# Bootstrap the workspace and install dependencies
melos bootstrap

# Run a script across all packages
melos run <script_name>

# Update dependencies
melos clean
melos get

# Publish packages
melos publish

# View package information
melos info
```

---

## 📚 Usage Example

#### Managing Multiple Packages

```bash
# Install dependencies for all packages
melos bootstrap

# Run custom scripts defined in pubspec.yaml
melos run build

# Clean all packages
melos clean
```

#### Publishing to pub.dev

```bash
# Check which packages are ready to publish
melos publish --dry-run

# Publish updated packages
melos publish
```

---

## 🤝 Contributing

We welcome contributions! Please help us improve Melos by:

1. **Reporting Issues** - Found a bug? [Open an issue](https://github.com/akhil-tg/Melos/issues)
2. **Submitting PRs** - Have an improvement? Submit a pull request
3. **Improving Docs** - Help us enhance documentation

For more details, see [CONTRIBUTING.md](CONTRIBUTING.md).

---

## 📄 License

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for details.

---

## 💬 Support & Community

- 📖 **Documentation** - Check out our [official docs](https://docs.melos.dev)
- 💭 **Discussions** - Join our community discussions
- 🐛 **Issues** - Report bugs or suggest features on [GitHub Issues](https://github.com/akhil-tg/Melos/issues)

---

## 📱 Connect

- GitHub: [@akhil-tg](https://github.com/akhil-tg)
- Twitter: [@your_twitter](https://twitter.com)

---

<div align="center">
  
Made with ❤️ by the Melos team

</div>