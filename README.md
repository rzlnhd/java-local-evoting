# Local & Secure Electronic Voting System

A Java-based local electronic voting system built with Spring Framework, designed for offline/LAN deployment. The system supports multi-role access for administration and ballot operations.

---

## Features

- **Multi-role access**: Super Administrator, Registrator, Operator, and Auditor
- **Dual-mode operation**: Administrative dashboard and Ballot interface in a single app
- **QR Code voter verification**: Voters are verified via QR code scanning during registration
- **Webcam integration**: Photo capture for voter and candidate registration
- **PDF form printing**: Prints voter registration cards
- **FTP image upload**: Stores photos to a central FTP server
- **Pie chart result visualization**: Live vote tally with XChart
- **Audit logging**: Every admin action is recorded

---

## Tech Stack

| Layer      | Technology                             |
| ---------- | -------------------------------------- |
| Language   | Java 17                                |
| Framework  | Spring Framework 4 (Core, MVC, TX)     |
| UI         | Java Swing (NetBeans Form Designer)    |
| ORM        | Hibernate 4                            |
| Database   | MySQL / MariaDB (via XAMPP/phpMyAdmin) |
| Build Tool | Maven                                  |
| QR Code    | ZXing                                  |
| Webcam     | Sarxos Webcam Capture                  |
| PDF        | Apache PDFBox                          |
| Charts     | XChart                                 |
| FTP        | Apache Commons Net                     |

---

## System Requirements

- Java 17+
- Maven 3.6+
- MySQL / MariaDB (e.g., via XAMPP)
- A local network if running multi-machine (Dashboard + Ballot on separate machines)

---

## Getting Started

### 1. Clone the repository

```bash
git clone <repo-url>
cd <repo-dir>
```

### 2. Install the missing dependency manually

The `fast-md5` library is not available on Maven Central and must be installed locally before building:

```bash
mvn install:install-file \
  -Dfile="./libs/fast-md5.jar" \
  -DgroupId=com.twmacinta \
  -DartifactId=fast-md5 \
  -Dversion=1.0.0 \
  -Dpackaging=jar
```

### 3. Set up the database

Start your local MySQL/MariaDB server (e.g., via XAMPP), then import the provided SQL dump:

```bash
mysql -u root -p voting < database/voting.sql
```

> The database contains Indonesian administrative region data (Province → Regency → District → Village) sourced circa 2018–2019. Some entries may no longer reflect current administrative boundaries.

### 4. Configure the database connection

On first launch, the app will prompt you to select a server. It will then generate a `config.properties` file at:

```
~/Documents/Local Voting/config.properties
```

You can also create or edit this file manually:

```properties
jdbc.driver=com.mysql.jdbc.Driver
jdbc.ip=127.0.0.1
jdbc.dbase=voting
jdbc.username=dbase
jdbc.password=root
```

> For a client machine connecting to a remote server, replace `127.0.0.1` with the server's LAN IP address.

### 5. Build and run

```bash
mvn compile
mvn exec:java
```

---

## Multi-Machine Setup

The system supports a server-client topology over a local network:

- **Server machine**: runs MySQL and the app as Dashboard (`Super Admin` / `Registrator` / `Auditor`)
- **Client machine(s)**: runs the app as Ballot (`Operator`), pointing to the server's IP

On first launch, a dialog lets you choose between `Localhost` (server mode) or entering a remote IP (client mode).

---

## User Roles

| Role                | Access                                                          |
| ------------------- | --------------------------------------------------------------- |
| Super Administrator | Full access: manage voters, candidates, polling stations, staff |
| Registrator         | Voter check-in and queue management                             |
| Operator            | Runs the ballot interface for voters to cast votes              |
| Auditor             | Read-only access to results and logs                            |

---

## Project Structure

```
databases/
└── voting.sql     # Database structure and default entries dump
src/main/java/com/voting/
├── dao/           # Data access layer (Hibernate)
├── model/         # JPA entities (master, transaksi, security)
├── service/       # Business logic interfaces and implementations
├── ui/            # Java Swing UI panels and dialogs
│   ├── frame/     # Main window and dialogs
│   ├── master/    # Voter, candidate, TPS management
│   ├── transaksi/ # Registration and ballot panels
│   ├── hasil/     # Results and attendance panels
│   └── security/  # Staff management and logs
└── util/          # Helpers: FTP upload, QR, printing, logging
libs/
└── fast-md5.jar   # Manual dependency
```

---

## Known Issues

- `Bundle.properties` files for UI labels are not loading correctly after migration from NetBeans to Maven. This is caused by the removal of the NetBeans platform runtime (`org.openide.util.NbBundle`). This will be addressed in the next development phase.

---

## Roadmap

- [x] Fix `Bundle.properties` loading (replace `NbBundle` with standard `ResourceBundle`)
- [ ] Migrate to **Spring Boot**
- [ ] Replace MySQL with an embedded database (**SQLite** or **H2**) for simpler deployment
- [ ] Replace NetBeans Form Designer UI with standard Swing or migrate to **JavaFX**
- [ ] Modernize password hashing (replace MD5 with BCrypt)
- [ ] Package as a single executable JAR

---

## License

This project was originally developed circa 2018 as a local government tooling project. Under [MIT](LICENSE) License
