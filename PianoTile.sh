#!/bin/bash
ROOT_DIR="$(cd "$(dirname "$0")" && pwd)"

if command -v setxkbmap >/dev/null 2>&1; then
  setxkbmap borne >/dev/null 2>&1 || true
fi
if command -v xdotool >/dev/null 2>&1; then
  xdotool mousemove 1280 1024 >/dev/null 2>&1 || true
fi

export SDL_RENDER_SCALE_QUALITY=0
export SDL_RENDER_BATCHING=1
export SDL_VIDEO_X11_NET_WM_BYPASS_COMPOSITOR=1
export SDL_VIDEO_MINIMIZE_ON_FOCUS_LOSS=0
export PYGAME_HIDE_SUPPORT_PROMPT=1
export PYTHONOPTIMIZE=1

cd "$ROOT_DIR/projet/PianoTile"

# Utilise le fond principal du jeu comme vignette de la borne.
if [ -f "./assets/img/page/ACCUEIL.png" ]; then
  cp -f "./assets/img/page/ACCUEIL.png" "./photo_small.png"
fi

PYTHON_BIN="python3.7"
if ! command -v "$PYTHON_BIN" >/dev/null 2>&1; then
  PYTHON_BIN="python3"
fi

if ! command -v "$PYTHON_BIN" >/dev/null 2>&1; then
  echo "Python3 introuvable. Installe Python 3 pour lancer PianoTile."
  exit 1
fi

"$PYTHON_BIN" app/game.py
