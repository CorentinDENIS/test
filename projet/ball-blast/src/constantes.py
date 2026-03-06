import pygame.font
import pygame

# Screen dimensions
SCREEN_WIDTH = 1240 #1024 
SCREEN_HEIGHT = 1024 #768 

# Colors
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
GREEN = (0,255,0)
BLUE = (0,0,255)

PLAYER_SPEED = 10

BALL_SPEED_X = 2
BALL_SPEED_FALL = 0.15
#BALL_TOP_BOUNCE = -11
BALL_TOP_BOUNCE = -17
#BALL_BOTTOM_BOUNCE = -9
BALL_BOTTOM_BOUNCE = -14
BALL_EQUIVALENT = 14
FIRERATE = 7

pygame.font.init()

#Fonts
FONT = pygame.font.SysFont('Comic Sans MS', 30)
FONT_SCORE = pygame.font.SysFont('Comic Sans MS', 18)

# Touches borne (J1) + fallback clavier quand le layout "borne" n'est pas actif.
KEY_BORNE_A = (pygame.K_f, pygame.K_AMPERSAND, pygame.K_1)
KEY_BORNE_B = (pygame.K_g, pygame.K_2)
KEY_BORNE_C = (pygame.K_h, pygame.K_3, pygame.K_QUOTEDBL)
KEY_BORNE_X = (pygame.K_r, pygame.K_4, pygame.K_QUOTE)
KEY_BORNE_Y = (pygame.K_t, pygame.K_5, pygame.K_LEFTPAREN)
KEY_BORNE_Z = (pygame.K_y, pygame.K_6, pygame.K_MINUS)

KEY_CONFIRM = (pygame.K_RETURN, pygame.K_KP_ENTER, pygame.K_SPACE) + KEY_BORNE_A + KEY_BORNE_B + KEY_BORNE_C + KEY_BORNE_X
KEY_BACK = (pygame.K_ESCAPE, pygame.K_q) + KEY_BORNE_A + KEY_BORNE_Z
KEY_MENU_UP = (pygame.K_UP, pygame.K_z, pygame.K_o, pygame.K_w)
KEY_MENU_DOWN = (pygame.K_DOWN, pygame.K_s, pygame.K_l)
