# 🎨 Documentação do Frontend: Youtube Converter & Player
## Tecnologias Principais

2. Comandos Iniciais
Abra o seu terminal na pasta raiz do projeto (fora da pasta do backend) e execute:
# 1. Criar o projeto com Vite e React (Variante TypeScript recomendada para robustez)
npm create vite@latest frontend -- --template react-ts

# 2. Entrar na pasta
cd frontend


```
src/
├── assets/             # Imagens, logotipos e fontes
├── components/         # Componentes reutilizáveis (Botões, Inputs, Cards)
│   ├── layout/         # Sidebar, Navbar, PlayerBar (Spotify style)
│   ├── ui/             # Componentes atômicos (Button, Input, Modal)
│   └── shared/         # Componentes compartilhados entre telas
├── contexts/           # Contextos de Autenticação e Tema (Light/Dark)
├── hooks/              # Hooks customizados (ex: useAuth, usePlayer)
├── pages/              # Páginas da aplicação
│   ├── Login/          # Tela de Login (Baseada no UI Kit enviado)
│   ├── Register/       # Tela de Cadastro
│   └── Dashboard/      # Interface principal (Spotify Style)
├── services/           # Configuração do Axios e chamadas de API
├── store/              # Estado global do Player (Zustand)
├── styles/             # CSS Global e configurações de tema
└── App.tsx             # Roteador principal

