# 🎵 Melos

> A cross-platform music streaming app powered by YouTube Music — beautiful, fast, and open-source.

<p align="center">
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/hero.gif" alt="Melos Hero" width="900" style="max-width:100%;border-radius:12px" />
</p>

<p align="center">
  <a href="#"><img alt="version" src="https://img.shields.io/badge/version-6.0.0-blue?style=for-the-badge" /></a>
  <a href="#"><img alt="license" src="https://img.shields.io/badge/license-GNU%20GPL%20v3-green?style=for-the-badge" /></a>
  <a href="#"><img alt="flutter" src="https://img.shields.io/badge/Flutter-3.29.3-blue?logo=flutter&style=for-the-badge" /></a>
  <a href="#"><img alt="platforms" src="https://img.shields.io/badge/platforms-Android%20%7C%20iOS%20%7C%20macOS%20%7C%20Windows%20%7C%20Linux-brightgreen?style=for-the-badge" /></a>
</p>

---

## Table of contents
- [About](#about)
- [Highlights](#highlights)
- [Features](#features)
- [Screenshots](#screenshots)
- [Tech Stack](#tech-stack)
- [Installation](#installation)
- [Usage](#usage)
- [Development & Contributing](#development--contributing)
- [Roadmap](#roadmap)
- [License](#license)
- [Support & Contact](#support--contact)

---

## About

**Melos** is an open-source Flutter app that brings YouTube Music streaming to desktop and mobile devices. It combines a Material You interface with robust offline support, AI-assisted recommendations, and desktop conveniences like system tray and a mini-player — all while staying lightweight and privacy-focused.

Melos is designed for users who want a single, consistent music experience across Android, iOS, Windows, macOS and Linux.

---

## Highlights

- ✨ Polished Material You UI with dynamic theming (light / dark / system)  
- 🔊 High-quality streaming from YouTube Music with a small-footprint player  
- ⬇️ Offline downloads with a local encrypted DB for metadata  
- 🧠 Smart queue generation & contextual recommendations  
- 🌐 Multi-language support (15+ languages)  
- 🖥 Desktop-first features: tray icon, mini-player, window controls

---

## Features

| Category | Features |
|---|---|
| 🎵 Music Streaming | Access millions of songs via YouTube Music streaming |
| ⬇️ Offline Mode | Download tracks to listen offline with QoS controls |
| 🤖 Smart Queue | AI-powered recommendations and auto-generated queue |
| 📝 Lyrics | Synced & timed lyrics display during playback |
| ☁️ Library Sync | Backup & restore your library (playlists, favorites) |
| 🌍 Cross-Platform | Android, iOS, Windows, macOS, Linux (one codebase) |
| 🎨 Theming | Material You dynamic theming + accent color picks |
| 🌐 Localization | 15+ languages with easy locale additions |
| 🖥 Desktop Tools | System tray, mini player, always-on-top mode, media keys |

---

## Screenshots

> Replace the placeholder links below with real screenshots/GIFs stored in `/assets/screenshots/` or hosted externally.

### Mobile
<p align="center">
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/mobile-home.gif" alt="Mobile Home" width="250" style="margin:6px;border-radius:8px" />
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/mobile-player.gif" alt="Mobile Player" width="250" style="margin:6px;border-radius:8px" />
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/mobile-lyrics.gif" alt="Mobile Lyrics" width="250" style="margin:6px;border-radius:8px" />
</p>

### Desktop
<p align="center">
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/desktop-playlist.gif" alt="Desktop Playlist" width="320" style="margin:6px;border-radius:8px" />
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/desktop-favorites.gif" alt="Desktop Favorites" width="320" style="margin:6px;border-radius:8px" />
  <img src="https://raw.githubusercontent.com/akhil-tg/Melos/main/assets/screenshots/desktop-downloads.gif" alt="Desktop Downloads" width="320" style="margin:6px;border-radius:8px" />
</p>

> Tip: Animated GIFs or short MP4s (under 5s) work best to communicate flows. Add them to `assets/screenshots/` and update these links.

---

## Tech Stack

| Layer | Technology |
|---:|:---|
| Framework | Flutter 3.29.3 |
| Language | Dart |
| Architecture | Clean Architecture (MVP-style boundaries) |
| Database | Isar (fast local DB for metadata) |
| Audio | just_audio + media_kit (low-latency playback) |
| State Management | flutter_modular |
| Streaming Source | YouTube Music API / scraping helpers |

---

## Installation

Prerequisites:
- Flutter 3.29.3 SDK installed (stable channel recommended)
- Platform tooling (Android SDK / Xcode / desktop toolchains)

Clone & run:

```bash
git clone https://github.com/akhil-tg/Melos.git
cd Melos

# Install packages
flutter pub get

# Run on a connected device
flutter run
