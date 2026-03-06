import pygame

class Button:
    def __init__(self):
        self.__buttons = {
            # Premier joueur
            pygame.K_r: False,
            pygame.K_t: False,
            pygame.K_y: False,
            pygame.K_QUOTE: False,
            pygame.K_f: False,
            pygame.K_AMPERSAND: False,
            pygame.K_g: False,
            pygame.K_h: False,  # Entrer
            # Deuxieme joueur
            pygame.K_a: False,
            pygame.K_z: False,
            pygame.K_e: False,
            pygame.K_q: False,
            pygame.K_z: False,
            pygame.K_d: False,  # Entrer
        }

    def update(self, event):
        """Met à jour l'état des boutons (1 à 6) et renvoie la direction ou la touche pressée."""
        if event.type != pygame.KEYDOWN:
            return None  # Ignore les événements non-clavier

        if event.key in (pygame.K_UP, pygame.K_o, pygame.K_w):
            return (0, -1)
        elif event.key in (pygame.K_DOWN, pygame.K_l, pygame.K_s):
            return (0, 1)
        elif event.key in (pygame.K_LEFT, pygame.K_k, pygame.K_a):
            return (-1, 0)
        elif event.key in (pygame.K_RIGHT, pygame.K_m, pygame.K_d):
            return (1, 0)

        if event.key in (pygame.K_h, pygame.K_r, pygame.K_RETURN, pygame.K_KP_ENTER, pygame.K_SPACE):
            return "enter"
        if event.key == pygame.K_r:
            return 0
        if event.key == pygame.K_t:
            return 1
        if event.key in (pygame.K_y, pygame.K_QUOTE):
            return 2
        if event.key in (pygame.K_f, pygame.K_AMPERSAND):
            return 3
        if event.key == pygame.K_g:
            return 4

        return None

    def getAll(self):
        """
        Retourne l'état de tous les boutons suivis sous forme de dictionnaire.
        Exemple : {pygame.K_r: False, pygame.K_t: True, ...}
        """
        return self.__buttons.copy()
