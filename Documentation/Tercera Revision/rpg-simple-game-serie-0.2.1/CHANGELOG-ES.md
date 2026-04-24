# Changelog

Todos los cambios notables en este proyecto se documentarán en este archivo

El formato del fichero se basa en: 
[Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto se adhiere a: 
[Semantic Versioning](https://semver.org/spec/v2.0.0.html)

## [Pendiente]

## [0.0.0] - 15-09-2023 (100,0 %)

Creación de la estructura básica del proyecto.

**Video**: _N/A_

## [0.1.0] - 16-09-2023 (100,0 %)

Creación de la estructura básica de panel de juego, que contendrá las 
definiciones de las propiedades básicas del juego y de la pantalla que lo 
contendrá, a su vez modificamos la clase principal de la aplicación para 
ejecutar este panel.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 1 - The Mechanism of 2D Games.mp4_

## [0.1.1] - 17-09-2023 (100,0 %)

Añadimos al panel de ejecución la funcionalidad de poder ser ejecutable 
(Runnable), es decir le ofrece la posibilidad de ser reproducible (play), 
pausable (pause) y detenible (Stop), ofreciendo la funcionalidad básica para 
poder implementar el ciclo de vida del juego.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 1 - The Mechanism of 2D Games.mp4_

## [0.2.0] - 18-09-2023 (99,0 %)

Definimos una primera implementación del ciclo de vida del juego, y 
establecemos las fases por las que el juego pasara con un detalle básico de las 
distintas funcionalidades que buscamos cubrir dentro de cada una de ellas. En 
un principio partimos de dos fases, una primera de actualización (Update), 
donde actualizaremos la información de los distintos componentes del juego,y 
tras esta tenemos la segunda, de dibujado (Draw) donde a partir de la 
información de los distintos componentes del juego pintaremos estos en pantalla.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_

## [0.2.1] - 19-09-2023 (99,3 %)

A partir de la definición de fases planteada en la versión anterior, 
desarrollamos cada una de las fases del ciclo de vida del juego, sobre cada una 
de ellas creamos el método determinado que añadiendo a estos métodos una 
funcionalidad mínima.

**Video**: _(RyiSnow) - How to Make a 2D Game in Java - Part 2 - Game Loop and Key Input.mp4_
