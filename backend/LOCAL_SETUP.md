Swagger link: http://localhost:8080/swagger-ui/index.html#/

# Instrukcja Uruchomienia Aplikacji Spring Boot z Bazą Danych wystawianą przez Dokcer Compose

## Wymagania Wstępne

1. **Docker:** Do uruchomienia bazy danych wymagany jest Docker. Instrukcja instalacji dostępna jest pod adresem: [Instalacja Docker](https://docs.docker.com/desktop/install/windows-install/). Narzędzie `docker compose` powinno być dostępne po instalacji Dockera, szczególnie w wersji Docker Desktop.

## Konfiguracja Projektu

1. Przechodzenie do katalogu backend projektu odbywa się poprzez wykonanie polecenia w terminalu:
```shell
cd backend
```

2. Następnie należy wystawić lokalnie bazę danych poprzez komende:

```shell
docker compose up
```
Baza zostanie stworzona na podstawie wartości zadeklarowanych w pliku `docker-compose.yml`, gdzie również znajdują wartość do połączenia się z bazą danych używając wybranego klienta.

## Uruchamianie Aplikacji

Dostępne są dwie opcje uruchomienia aplikacji:

### Opcja 1: Uruchamianie za pomocą Gradle

1. W terminalu, będąc w katalogu `backend`, aplikacja może być uruchomiona za pomocą Gradle poprzez polecenie:

```shell
./gradlew runBoot
```


### Opcja 2: Uruchamianie za pomocą IntelliJ IDEA

1. Po otwarciu projektu w IntelliJ IDEA, główna klasa aplikacji Spring Boot (zazwyczaj nazwana `Application` lub podobnie) może zostać uruchomiona poprzez kliknięcie prawym przyciskiem myszy i wybranie 'Run'.


```shell
Sometimes it is also necessary to manually configure your IDE.

In IntelliJ IDEA, open Settings and add -parameters to the following field.

Build, Execution, Deployment → Compiler → Java Compiler → Additional command line parameters

Then rebuild the project with ctrl + F9
```