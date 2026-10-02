# Overworld Portal

Mod para **Minecraft 1.20.1 (Forge 47.4.0)**. Adiciona um bloco visualmente idêntico ao portal do End,
mas que leva qualquer entidade que o atravesse para o **Overworld** (spawn do mundo).
O portal original do End continua funcionando normalmente.

## Como funciona (resumo)
- `OverworldPortalBlock` herda de `EndPortalBlock` e troca o destino em `entityInside`.
- `OverworldPortalBlockEntity` + `ClientSetup` reaproveitam o renderer do portal do End (mesma aparência).
- `OverworldTeleporter` (`ITeleporter`) escolhe o ponto de chegada e impede os créditos finais.

## Gerar o .jar
Requisitos: **JDK 17** e internet (na primeira vez o Gradle baixa Minecraft e Forge, leva alguns minutos).

```bash
./gradlew build        # Windows: gradlew.bat build
```
O arquivo final fica em `build/libs/overworldportal-1.0.0.jar`. Coloque-o na pasta `mods` de uma instalação do Forge 1.20.1.

> O Gradle também gera `...-sources` ou similares dependendo da config; o jar do mod é o `overworldportal-1.0.0.jar`.

## Testar no ambiente de desenvolvimento
```bash
./gradlew runClient
```
No jogo (modo criativo): `/give @s overworldportal:overworld_portal`
ou `/setblock ~ ~ ~ overworldportal:overworld_portal`. Vá ao Nether e pise no bloco.

## Build automático no GitHub
O workflow `.github/workflows/build.yml` compila a cada push. Baixe o jar na aba **Actions → (execução) → Artifacts**.

## Antes de publicar
- Edite `mod_authors` e `mod_license` em `gradle.properties` (escolha uma licença em https://choosealicense.com).
- Se renomear o pacote `com.example.overworldportal`, ajuste também `mod_group_id`.
