'use client';
import { motion } from 'framer-motion';
import { Home, Library, Settings, Search, Play, SkipBack, SkipForward, Volume2, Link as LinkIcon } from 'lucide-react';

export default function Dashboard() {
  return (
    <div className="flex h-screen bg-wavr-dark text-white overflow-hidden">
      
      {/* Sidebar - Estilo Apple/Spotify */}
      <aside className="w-64 border-r border-white/5 p-8 flex flex-col justify-between glass">
        <div>
          <h1 className="text-2xl font-bold mb-12 tracking-tighter italic">WAVR</h1>
          <nav className="space-y-6">
            <div className="flex items-center gap-3 text-wavr-accent font-medium cursor-pointer">
              <Home size={20} /> Dashboard
            </div>
            <div className="flex items-center gap-3 text-wavr-textSecondary hover:text-white transition-colors cursor-pointer">
              <Library size={20} /> Biblioteca
            </div>
            <div className="flex items-center gap-3 text-wavr-textSecondary hover:text-white transition-colors cursor-pointer">
              <Settings size={20} /> Configurações
            </div>
          </nav>
        </div>

        <div className="flex items-center gap-3 p-3 bg-white/5 rounded-2xl border border-white/10">
          <div className="size-10 bg-gradient-to-tr from-wavr-accent to-green-500 rounded-full" />
          <div className="text-sm">
            <p className="font-medium">Admin</p>
            <p className="text-wavr-textSecondary text-xs">Premium</p>
          </div>
        </div>
      </aside>

      {/* Área Principal */}
      <main className="flex-1 flex flex-col overflow-y-auto p-12 pb-32">
        <header className="mb-10">
          <p className="text-wavr-textSecondary text-sm uppercase tracking-widest mb-2">Bem-vindo de volta</p>
          <h2 className="text-4xl font-bold">Sua Biblioteca</h2>
        </header>

        {/* Input de Conversão Premium */}
        <section className="glass p-8 rounded-apple mb-12 border border-wavr-accent/10">
          <h3 className="text-lg font-medium mb-4 flex items-center gap-2">
            <LinkIcon size={18} className="text-wavr-accent" /> Converter Link do YouTube
          </h3>
          <div className="flex gap-4">
            <input 
              className="flex-1 bg-white/5 border border-white/10 rounded-xl px-6 outline-none focus:border-wavr-accent transition-all text-sm"
              placeholder="Cole a URL do vídeo aqui..."
            />
            <motion.button 
              whileHover={{ scale: 1.02 }}
              className="bg-wavr-accent text-black px-10 py-3 rounded-xl font-bold shadow-lg"
            >
              Converter
            </motion.button>
          </div>
        </section>

        {/* Lista de Músicas com Microinterações */}
        <div className="space-y-3">
          {[1, 2, 3].map((i) => (
            <motion.div
              key={i}
              whileHover={{ x: 10, backgroundColor: "rgba(255,255,255,0.05)" }}
              className="flex items-center justify-between p-4 rounded-xl border border-transparent hover:border-wavr-accent/20 cursor-pointer transition-all group"
            >
              <div className="flex items-center gap-5">
                <div className="size-14 bg-white/10 rounded-lg flex items-center justify-center group-hover:bg-wavr-accent/20 transition-all">
                   <Play size={20} className="text-wavr-accent opacity-0 group-hover:opacity-100 transition-all" />
                </div>
                <div>
                  <p className="font-semibold text-lg">Música {i}</p>
                  <p className="text-sm text-wavr-textSecondary">Canal do YouTube • 2024</p>
                </div>
              </div>
              <p className="text-wavr-textSecondary text-sm">04:20</p>
            </motion.div>
          ))}
        </div>
      </main>

      {/* Player Fixo (Spotify Style + Apple Clean) */}
      <footer className="fixed bottom-0 w-full bg-[#0B0F19]/80 backdrop-blur-2xl border-t border-white/5 p-5 flex items-center justify-between px-12">
        <div className="flex items-center gap-5 w-1/4">
          <div className="size-16 bg-white/10 rounded-xl border border-white/10 shadow-lg" />
          <div>
            <p className="font-bold">Nenhuma música</p>
            <p className="text-xs text-wavr-textSecondary">Selecione para ouvir</p>
          </div>
        </div>

        {/* Controles Centrais */}
        <div className="flex flex-col items-center gap-3 w-2/4">
          <div className="flex items-center gap-8">
            <SkipBack size={22} className="text-wavr-textSecondary cursor-pointer hover:text-white" />
            <motion.button whileHover={{ scale: 1.1 }} className="bg-white text-black size-12 rounded-full flex items-center justify-center shadow-glow">
              <Play fill="black" size={20} />
            </motion.button>
            <SkipForward size={22} className="text-wavr-textSecondary cursor-pointer hover:text-white" />
          </div>
          <div className="w-full max-w-xl flex items-center gap-3 text-xs text-wavr-textSecondary font-mono">
            <span>0:00</span>
            <div className="flex-1 bg-white/10 h-1 rounded-full relative overflow-hidden">
               <div className="absolute left-0 top-0 h-full bg-wavr-accent w-1/3 rounded-full" />
            </div>
            <span>4:20</span>
          </div>
        </div>

        {/* Volume */}
        <div className="w-1/4 flex justify-end items-center gap-3">
          <Volume2 size={18} className="text-wavr-textSecondary" />
          <div className="w-24 bg-white/10 h-1 rounded-full">
            <div className="bg-white h-full w-3/4 rounded-full" />
          </div>
        </div>
      </footer>
    </div>
  );
}