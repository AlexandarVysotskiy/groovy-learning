package eight

import eight.scripts.ScriptForImport


static String hello() {
    "Hello, ${new ScriptForImport().message}"
}

int maxSalary

for (s in salaryList) {
    if (maxSalary < s) {
        maxSalary = s
    }
}

maxSalary