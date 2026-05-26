## 🔹 1. JVM (Java Virtual Machine)

👉 JVM is the **engine that runs Java programs**

* It executes **bytecode**
* Platform-dependent (different JVM for Windows, Linux, Mac)
* Handles:

  * memory management
  * garbage collection
  * execution of code

📌 Key point:

> JVM converts bytecode → machine code

---

## 🔹 2. JRE (Java Runtime Environment)

👉 JRE = **JVM + libraries needed to run Java**

* Contains:

  * JVM
  * Core libraries (java.lang, java.util, etc.)

📌 Purpose:

> Run Java applications (but cannot develop)

---

## 🔹 3. JDK (Java Development Kit)

👉 JDK = **JRE + development tools**

* Contains:

  * JRE
  * Compiler (`javac`)
  * Tools like debugger, javadoc

📌 Purpose:

> Develop + run Java programs

---

## 🔥 Relationship

```text
JDK > JRE > JVM
```

👉 Meaning:

* JDK includes JRE
* JRE includes JVM

---

# 🔹 4. Bytecode

When you compile Java:

```java
javac Main.java
```

👉 It generates:

```text
Main.class
```

👉 This `.class` file contains **bytecode**

---

## 🧠 What is Bytecode?

* Intermediate code (not machine code)
* Platform-independent
* Executed by JVM

---

# 🔹 5. Write Once, Run Anywhere (WORA)

👉 Java slogan

> “Write code once → run on any system”

---

## 🧠 How it works

1. Write Java code → `Main.java`
2. Compile → bytecode (`Main.class`)
3. Run on any system with JVM

```text
Windows JVM → runs bytecode  
Linux JVM → runs same bytecode  
Mac JVM → runs same bytecode  
```