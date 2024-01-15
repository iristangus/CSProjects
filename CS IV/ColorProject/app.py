from flask import Flask, render_template
import random
import numpy as np

app = Flask(__name__)

@app.route('/')
def index():
    palette = HEXpalette()
    randColor = RGBtoHEX(randomColor())
    return render_template('index.html.j2', color1 = palette[0], color2 = palette[1], color3 = palette[2],
     color4 = palette[3], color5 = palette[4], randColor = randColor)


## Makes a random color (3 random ints as RGB values)
def randomColor():
    newColor = []
    for i in range(3):
        newColor.append(random.randrange(255))
    return newColor

## Finds the sorting value
def sortValue(color):
    r = color[0]
    g = color[1]
    b = color[2]
    
    # proportional to the value of the HSV
    value = max(r, g, b)
    
    # hue of HSV
    if (g >= b):
        hue = np.arccos((r - g/2 - b/2)/(r**2 + g**2 + b**2 - r*g - r*b - g*b)**0.5)
    else:
        hue = 360 - np.arccos((r - g/2 - b/2)/(r**2 + g**2 + b**2 - r*g - r*b - g*b)**0.5)
    
    return hue
    
## Makes a color palette of 5 random colors
def randomPalette():
    palette = []
    for i in range(5):
        palette.append(randomColor())
    return palette

## Adds a color overlay over a palette
def overlayedPalette(palette):
    newPalette = []
    overlayColor = randomColor()
    
    for color in palette:
        newColor = []
        # calulates the RGB values of the new color
        for i in range(3):
            target = 0.5 * overlayColor[i] + 0.5 * color[i]
            newColor.append(round(target))
        # adds the sorting value of the new color
        newColor.append(sortValue(newColor))
        newPalette.append(newColor)
        
    # sorts the list by the 3rd index of each list (the sorting value)
    newPalette.sort(key = lambda x: x[3])
        
    return newPalette
    
## Converts a color from RGB to HEX
# https://stackoverflow.com/questions/49467278/flask-python-and-css-variable
def RGBtoHEX(color):
    # if there's a sorting value still in the list
    if len(color) > 3:
        color.pop()
    return '#{:02x}{:02x}{:02x}'.format(*color)

## Converts a RGB palette to a HEX palette
def RGBtoHEXpalette(palette):
    HEXpalette = []
    for i in range(len(palette)):
        HEX = RGBtoHEX(palette[i])
        HEXpalette.append(HEX)
    return(HEXpalette)
    
## Creates a HEX palette
def HEXpalette():
    palette = overlayedPalette(randomPalette())
    HEXp = RGBtoHEXpalette(palette)
    return HEXp

## Converts from
    
#palette = randomPalette()
#overlayPalette = overlayedPalette(palette)
#RGBtoHEXpalette(palette)
#RGBtoHEXpalette(overlayPalette)