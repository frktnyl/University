with open("server_logs.txt", "r") as logFile:

    errorCounter = 0
    infos = []
    errors = []
    warnings = []

    for line in logFile:
        if "INFO" in line:
            infos.append(line)
        elif "ERROR" in line:
            errorCounter += 1
            errors.append(line)
        elif "WARNING" in line:
            warnings.append(line)

with open("info_logs.txt", "w") as infoLogs:
    infoLogs.writelines(infos)
with open("error_logs.txt", "w") as errorLogs:
    errorLogs.writelines(errors)
with open("warnings_logs.txt", "w") as warningLogs:
    warningLogs.writelines(warnings)

print(f"There are {errorCounter} errors in this file.")