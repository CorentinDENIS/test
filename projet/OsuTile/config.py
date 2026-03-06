# config.py

import pygame

# === Fenêtre ===
SCREEN_WIDTH = 1280
SCREEN_HEIGHT = 960
FPS = 60
FULLSCREEN = True

# === Affichage ===
BACKGROUND_COLOR = (0, 0, 0)
LANE_COLOR = (200, 200, 200)
TEXT_COLOR = (255, 255, 255)
HIGHLIGHT_COLOR = (255, 255, 0)

# === Jeu ===
LANE_COUNT = 4
TILE_COLOR = (0, 150, 255)
HIT_LINE_Y = 800
FALL_TIME = 1.5
TILE_HEIGHT = 50
HIT_BOX_PIXEL = 30  # Tolérance

# === Contrôles ===
# Mappage des touches de jeu par colonne

KEY_MAPPING = {
    0: (pygame.K_r, pygame.K_4, pygame.K_a),
    1: (pygame.K_t, pygame.K_5, pygame.K_LEFTPAREN, pygame.K_z),
    2: (pygame.K_y, pygame.K_QUOTE, pygame.K_e),
    3: (pygame.K_f, pygame.K_1, pygame.K_AMPERSAND, pygame.K_q),
}

PAUSE_KEYS = (pygame.K_f, pygame.K_AMPERSAND, pygame.K_1, pygame.K_p, pygame.K_t, pygame.K_5, pygame.K_LEFTPAREN)

# Contrôles de navigation dans les menus
MENU_UP_KEYS = (pygame.K_UP, pygame.K_o, pygame.K_w)
MENU_DOWN_KEYS = (pygame.K_DOWN, pygame.K_l, pygame.K_s)
MENU_SELECT_KEYS = (
    pygame.K_g,
    pygame.K_2,
    pygame.K_h,
    pygame.K_3,
    pygame.K_QUOTEDBL,
    pygame.K_RETURN,
    pygame.K_r,
    pygame.K_4,
    pygame.K_QUOTE,
    pygame.K_f,
    pygame.K_1,
    pygame.K_AMPERSAND,
    pygame.K_SPACE,
)
MENU_BACK_KEYS = (
    pygame.K_h,
    pygame.K_3,
    pygame.K_QUOTEDBL,
    pygame.K_f,
    pygame.K_AMPERSAND,
    pygame.K_1,
    pygame.K_ESCAPE,
    pygame.K_y,
    pygame.K_QUOTE,
)

# Contrôles pour les menus (pause, fin)

MENU_RESUME_KEYS = (
    pygame.K_g,
    pygame.K_2,
    pygame.K_h,
    pygame.K_3,
    pygame.K_QUOTEDBL,
    pygame.K_RETURN,
    pygame.K_r,
    pygame.K_4,
    pygame.K_QUOTE,
    pygame.K_f,
    pygame.K_1,
    pygame.K_AMPERSAND,
    pygame.K_SPACE,
)
MENU_QUIT_KEYS = (
    pygame.K_h,
    pygame.K_3,
    pygame.K_QUOTEDBL,
    pygame.K_f,
    pygame.K_AMPERSAND,
    pygame.K_1,
    pygame.K_ESCAPE,
    pygame.K_y,
    pygame.K_QUOTE,
)
MENU_BACK_TO_MENU_KEYS = (pygame.K_s, pygame.K_y, pygame.K_QUOTE)
MENU_RETRY_KEYS = (pygame.K_d, pygame.K_r, pygame.K_4, pygame.K_QUOTE, pygame.K_RETURN, pygame.K_SPACE)

# === Fichiers ===
BEATMAP_FOLDER = "beatmaps"
ASSETS_FOLDER = "assets"

# === Textes d'interface ===
MENU_TITLE = "Piano Tile Arcade"
SELECT_PROMPT = "Sélectionne une chanson"
