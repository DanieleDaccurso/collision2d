# Collision2D
Collision2D is a simple collision calculator written in Java. It's currently in Alpha status / work in progress, but already usable. 

## Features: 
- collision point calculation
- hitboxes consisting of many rectangles, forming more complex shapes
- usable with any kind of canvas (Android, Swing etc)
- very small interfaces (you can use your own entites, rectangles etc)
- test: 100% code coverage

Let's assume two entities: 

```
Entity e = new Entity();
e.getHitBox().addRectangle(new Rectangle(0,0,100,100));

Entity f = new Entity();
f.getHitBox().addRectangle(new Rectangle(50,50,200,200));
```

You can check collisions on various levels, after calling the collision result: 

```
CollisionResult collsion = e.getCollision(f);
``` 

First, you can check if a collision of two hitboxes is possible or not. 
This is a fast calculation, which will give you a hint on whenever you can check for more precise collisions: 

```
boolean collisionIsPossible = collsion.hasSoftContact();
```

to check if a collision actually happened, you can check the hard contact: 

```
boolean collisionHappened = collsion.hasHardContact();
```

You can also check for intersection points: 

``` 
Iterator<CoordinatePoint> pointIterator = r.calculatePoints().iterator();
while (pointIterator.hasNext()) {
    System.out.println(pointIterator.next());
}

// will output: 
// X = 100.0 / Y = 50.0
// X = 50.0 / Y = 100.0
```

Todos / Work in progress: 

- Complexity of Point calculation is unnecessarily high, reduce this
- Rectangles already have an optional name. Implement rectangle pair detection (ex. "leg" colliding with "head")
