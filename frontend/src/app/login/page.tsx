'use client';
import { motion } from 'framer-motion';
import { Mail, Lock, Eye, Music } from 'lucide-react';

export default function LoginPage() {
  return (
    <div className="flex min-h-screen bg-wavr-dark text-white font-sans">
      
      {/* Lado Esquerdo - Branding */}
      <div className="hidden lg:flex w-1/2 flex-col justify-between p-16 bg-gradient-to-br from-[#0B0F19] to-[#1A2233]">
        <div>
          <h1 className="text-6xl font-bold tracking-tighter italic">WAVR</h1>
          <h2 className="mt-10 text-4xl font-medium leading-tight">
            Sua música. <br />
            <span className="text-wavr-accent">Do jeito certo.</span>
          </h2>
          <p className="mt-6 text-wavr-textSecondary text-xl max-w-md">
            Converta links do YouTube para MP3 e separe stems com IA.
          </p>
        </div>

        {/* Equalizador Animado */}
        <div className="flex items-end gap-1.5 h-16">
          {[...Array(12)].map((_, i) => (
            <motion.div
              key={i}
              animate={{ height: [10, 50, 20, 64, 15] }}
              transition={{ repeat: Infinity, duration: 1.5, delay: i * 0.1, ease: "easeInOut" }}
              className="w-2 bg-wavr-accent rounded-full opacity-80"
            />
          ))}
        </div>
      </div>

      {/* Lado Direito - Login Card */}
      <div className="w-full lg:w-1/2 flex items-center justify-center p-8">
        <motion.div 
          initial={{ opacity: 0, y: 20 }}
          animate={{ opacity: 1, y: 0 }}
          className="glass w-full max-w-md p-10 rounded-apple shadow-2xl"
        >
          <h3 className="text-2xl font-semibold mb-8">Bem-vindo</h3>
          
          <div className="space-y-6">
            <div className="space-y-2">
              <label className="text-sm text-wavr-textSecondary">E-mail</label>
              <div className="relative">
                <Mail className="absolute left-4 top-1/2 -translate-y-1/2 text-wavr-textSecondary size-5" />
                <input className="w-full bg-white/5 border border-white/10 rounded-xl py-3 pl-12 focus:border-wavr-accent outline-none transition-all" placeholder="admin" />
              </div>
            </div>

            <div className="space-y-2">
              <label className="text-sm text-wavr-textSecondary">Senha</label>
              <div className="relative">
                <Lock className="absolute left-4 top-1/2 -translate-y-1/2 text-wavr-textSecondary size-5" />
                <input type="password" title="admin" className="w-full bg-white/5 border border-white/10 rounded-xl py-3 pl-12 focus:border-wavr-accent outline-none transition-all" placeholder="••••••••" />
                <Eye className="absolute right-4 top-1/2 -translate-y-1/2 text-wavr-textSecondary size-5 cursor-pointer" />
              </div>
            </div>

            <motion.button 
              whileHover={{ scale: 1.03, boxShadow: "0 0 20px rgba(183, 255, 60, 0.4)" }}
              whileTap={{ scale: 0.98 }}
              className="w-full bg-wavr-accent text-black font-bold py-4 rounded-xl mt-4 transition-all"
            >
              Começar a ouvir
            </motion.button>
            
            <p className="text-center text-sm text-wavr-textSecondary">
              Não tem uma conta? <span className="text-wavr-accent cursor-pointer hover:underline">Criar conta</span>
            </p>
          </div>
        </motion.div>
      </div>
    </div>
  );
}