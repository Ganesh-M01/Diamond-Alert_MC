# 💎 Diamond Alert

A simple Minecraft **Paper plugin** that alerts staff members whenever players mine natural diamond ores.  
Designed as a lightweight **anti-xray / suspicious mining detector**.

---

## ✨ Features
- Sends a staff alert when a player mines natural diamond ore
- Ignores **player-placed diamond ores** (so fortune mining at base won’t spam alerts)
- Configurable alert threshold:
  - If a player mines more than X diamonds in Y seconds, a **suspicious activity alert** is triggered
- Lightweight and optimized for survival/SMP servers

---

## 🛠️ Installation
1. Download the latest release from [Releases](../../releases)
2. Place the `.jar` file into your server’s `/plugins` folder
3. Restart your Paper server
4. Done! 🎉

---

## ⚙️ Permissions
| Permission                  | Description                                 |
|-----------------------------|---------------------------------------------|
| `diamondalert.notify`       | Allows staff members to see diamond alerts |

> ⚠️ Make sure staff members (moderators/admins) have this permission.

---

## 📋 Example Alerts
When a player breaks a natural diamond ore:
[DiamondAlert] Player Steve mined Diamond Ore at (123, 12, -456)

When a player mines too many diamonds too quickly:
[DiamondAlert] ⚠ Suspicious: Steve mined 8 diamonds in 60 seconds!


---

## 📌 Roadmap / To-Do
- [ ] Configurable ore types (emeralds, ancient debris, etc.)
- [ ] Log alerts to a file
- [ ] Discord webhook integration
- [ ] GUI for staff to review suspicious mining

---

## 🧑‍💻 Development
Built with:
- [Paper API](https://papermc.io/) `1.20+`
- Java 17+

To build from source:
```bash
git clone https://github.com/Ganesh-M01/DiamondAlert.git
cd DiamondAlert
mvn clean package
```

Output JAR will be in the target/ folder.
