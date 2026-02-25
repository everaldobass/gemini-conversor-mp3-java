import type { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  darkMode: 'class', // Permite trocar entre Light e Dark mode
  theme: {
    extend: {
      colors: {
        // Cores baseadas no seu prompt
        wavr: {
          dark: "#0B0F19",
          card: "#121826",
          cardLight: "#FFFFFF",
          accent: "#B7FF3C", // Verde Neon
          accentApple: "#A3FF12", // Verde Apple
          textPrimary: "#FFFFFF",
          textSecondary: "#9CA3AF",
          lightBg: "#F5F7FA",
        }
      },
      borderRadius: {
        'apple': '16px', // Bordas de 16px conforme solicitado
      }
    },
  },
  plugins: [],
};
export default config;