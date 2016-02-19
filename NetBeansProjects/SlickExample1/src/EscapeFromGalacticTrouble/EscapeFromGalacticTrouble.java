package EscapeFromGalacticTrouble;

import org.newdawn.slick.state.*;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Iterator;

import java.util.logging.Level;

import java.util.logging.Logger;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;

import org.newdawn.slick.AppGameContainer;

import org.newdawn.slick.BasicGame;

import org.newdawn.slick.Font;

import org.newdawn.slick.GameContainer;

import org.newdawn.slick.Graphics;

import org.newdawn.slick.Image;

import org.newdawn.slick.Input;

import org.newdawn.slick.SlickException;

import org.newdawn.slick.SpriteSheet;

import org.newdawn.slick.TrueTypeFont;

import org.newdawn.slick.geom.Rectangle;

import org.newdawn.slick.geom.Shape;

import org.newdawn.slick.state.BasicGameState;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import org.newdawn.slick.tiled.TiledMap;
import org.w3c.dom.css.Rect;

public class EscapeFromGalacticTrouble extends BasicGameState {

    public Item healthpotion, healthpotion1;
    public Sugar speedpotion, speedpotion1;
    public Itemwin antidote;
    public ONIONS gerndaez;
    public Enemy Cronk;
    public Ladder ladderitem1;
    boolean isLand = true;

    public ArrayList<Item> stuff = new ArrayList();

    public ArrayList<Sugar> stuff1 = new ArrayList();

    public ArrayList<Itemwin> stuffwin = new ArrayList();

    public ArrayList<ONIONS> gernadez = new ArrayList();

    public ArrayList<Ladder> stuff2 = new ArrayList();

    private boolean[][] hostiles;

    private static TiledMap grassMap;

    private static AppGameContainer app;

    private static Camera camera;

    public static int counter = 0;

    private Animation sprite, up, down, left, right, wait;

    private static final int SIZE = 16;

    private static final int SCREEN_WIDTH = 1000;

    private static final int SCREEN_HEIGHT = 750;

    public EscapeFromGalacticTrouble(int xSize, int ySize) {

    }

    public void init(GameContainer gc, StateBasedGame sbg)
            throws SlickException {

        gc.setTargetFrameRate(60);

        gc.setShowFPS(false);

        grassMap = new TiledMap("res/Maze.tmx");

        // Ongoing checks are useful
        System.out.println("Tile map is this wide: " + grassMap.getWidth());

        camera = new Camera(gc, grassMap);

		// *********************************************************************************
        // Player stuff --- these things should probably be chunked into methods
        // and classes
        // *********************************************************************************
        SpriteSheet runningSS = new SpriteSheet(
                "res/ogrespritesheet.png", 16, 16, 0);

		// System.out.println("Horizontal count: "
        // +runningSS.getHorizontalCount());
        // System.out.println("Vertical count: " +runningSS.getVerticalCount());
        up = new Animation();

        up.setAutoUpdate(true);

        up.addFrame(runningSS.getSprite(0, 8), 330);

        up.addFrame(runningSS.getSprite(1, 8), 330);

        up.addFrame(runningSS.getSprite(2, 8), 330);

        up.addFrame(runningSS.getSprite(3, 8), 330);

        up.addFrame(runningSS.getSprite(4, 8), 330);

        up.addFrame(runningSS.getSprite(5, 8), 330);

        up.addFrame(runningSS.getSprite(6, 8), 330);

        up.addFrame(runningSS.getSprite(7, 8), 330);

        up.addFrame(runningSS.getSprite(8, 8), 330);

        down = new Animation();

        down.setAutoUpdate(false);

        down.addFrame(runningSS.getSprite(0, 10), 330);

        down.addFrame(runningSS.getSprite(1, 10), 330);

        down.addFrame(runningSS.getSprite(2, 10), 330);

        down.addFrame(runningSS.getSprite(3, 10), 330);

        down.addFrame(runningSS.getSprite(4, 10), 330);

        down.addFrame(runningSS.getSprite(5, 10), 330);

        down.addFrame(runningSS.getSprite(6, 10), 330);

        down.addFrame(runningSS.getSprite(7, 10), 330);

        down.addFrame(runningSS.getSprite(8, 10), 330);

        left = new Animation();

        left.setAutoUpdate(false);

        left.addFrame(runningSS.getSprite(0, 9), 330);

        left.addFrame(runningSS.getSprite(1, 9), 330);

        left.addFrame(runningSS.getSprite(2, 9), 330);

        left.addFrame(runningSS.getSprite(3, 9), 330);

        left.addFrame(runningSS.getSprite(4, 9), 330);

        left.addFrame(runningSS.getSprite(5, 9), 330);

        left.addFrame(runningSS.getSprite(6, 9), 330);

        left.addFrame(runningSS.getSprite(7, 9), 330);

        left.addFrame(runningSS.getSprite(8, 9), 330);

        right = new Animation();

        right.setAutoUpdate(false);

        right.addFrame(runningSS.getSprite(0, 11), 330);

        right.addFrame(runningSS.getSprite(1, 11), 330);

        right.addFrame(runningSS.getSprite(2, 11), 330);

        right.addFrame(runningSS.getSprite(3, 11), 330);

        right.addFrame(runningSS.getSprite(4, 11), 330);

        right.addFrame(runningSS.getSprite(5, 11), 330);

        right.addFrame(runningSS.getSprite(6, 11), 330);

        right.addFrame(runningSS.getSprite(7, 11), 330);

        right.addFrame(runningSS.getSprite(8, 11), 330);

        wait = new Animation();

        wait.setAutoUpdate(true);

        wait.addFrame(runningSS.getSprite(0, 14), 733);

        wait.addFrame(runningSS.getSprite(1, 14), 733);

        wait.addFrame(runningSS.getSprite(2, 14), 733);

        wait.addFrame(runningSS.getSprite(3, 14), 733);

		// wait.addFrame(runningSS.getSprite(2, 14), 733);
        // wait.addFrame(runningSS.getSprite(5, 14), 333);
        sprite = wait;

		// *****************************************************************
        // Obstacles etc.
        // build a collision map based on tile properties in the TileD map
        Blocked.Blocked = new boolean[grassMap.getWidth()][grassMap.getHeight()];

		// System.out.println("Map height:" + grassMap.getHeight());
        // System.out.println("Map width:" + grassMap.getWidth());
        // There can be more than 1 layer. You'll check whatever layer has the
        // obstacles.
        // You could also use this for planning traps, etc.
        // System.out.println("Number of tile layers: "
        // +grassMap.getLayerCount());
        System.out.println("The grassmap is " + grassMap.getWidth() + "by "
                + grassMap.getHeight());

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {

            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {

				// int tileID = grassMap.getTileId(xAxis, yAxis, 0);
                // Why was this changed?
                // It's a Different Layer.
                // You should read the TMX file. It's xml, i.e.,human-readable
                // for a reason
                int tileID = grassMap.getTileId(xAxis, yAxis, 0);

                String value = grassMap.getTileProperty(tileID,
                        "Blocked", "false");

                if ("true".equals(value)) {

                    System.out.println("The tile at x " + xAxis + " andy axis "
                            + yAxis + " is blocked.");

                    Blocked.Blocked[xAxis][yAxis] = true;

                }

            }

        }

        System.out.println("Array length" + Blocked.Blocked[0].length);

        hostiles = new boolean[grassMap.getWidth()][grassMap.getHeight()];

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.Blocked[xBlock][yBlock]) {
                    if (yBlock % 7 == 0 && xBlock % 15 == 0) {
                        Item i = new Item(xAxis * SIZE, yAxis * SIZE);
                        stuff.add(i);

                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        for (int xAxis = 0; xAxis < grassMap.getWidth(); xAxis++) {
            for (int yAxis = 0; yAxis < grassMap.getHeight(); yAxis++) {
                int xBlock = (int) xAxis;
                int yBlock = (int) yAxis;
                if (!Blocked.Blocked[xBlock][yBlock]) {
                    if (xBlock % 9 == 0 && yBlock % 25 == 0) {
                        Sugar h = new Sugar(xAxis * SIZE, yAxis * SIZE);

                        stuff1.add(h);
                        hostiles[xAxis][yAxis] = true;
                    }
                }
            }
        }

        healthpotion = new Item(100, 100);
        healthpotion1 = new Item(450, 400);
        stuff.add(healthpotion);
        stuff.add(healthpotion1);

        ladderitem1 = new Ladder(100, 100, 16, 16);
        stuff2.add(ladderitem1);

        speedpotion = new Sugar(100, 150);
        speedpotion1 = new Sugar(450, 100);
        stuff1.add(speedpotion);
        stuff1.add(speedpotion1);

        antidote = new Itemwin(3004, 92);
        stuffwin.add(antidote);
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
            throws SlickException {

        camera.centerOn((int) Player.x, (int) Player.y);

        camera.drawMap();

        camera.translateGraphics();

        sprite.draw((int) Player.x, (int) Player.y);

        g.drawString("x: " + (int) Player.x + "y: " + (int) Player.y, Player.x, Player.y - 10);
        g.drawString("Health: " + Player.health / 1000, camera.cameraX + 10,
                camera.cameraY + 10);

        g.drawString("speed: " + (int) (Player.speed * 10), camera.cameraX + 10,
                camera.cameraY + 25);

        g.draw(Player.rect);
        g.drawString("time passed: " + counter / 1000, camera.cameraX + 600, camera.cameraY);
        // moveenemies();

        for (Item i : stuff) {
            if (i.isvisible) {
                i.currentImage.draw(i.x, i.y);
                // draw the hitbox
                //g.draw(i.hitbox);

            }
        }

        for (Sugar h : stuff1) {
            if (h.isvisible) {
                h.currentImage.draw(h.x, h.y);
                // draw the hitbox
                //g.draw(h.hitbox);

            }
        }

        for (Itemwin w : stuffwin) {
            if (w.isvisible) {
                w.currentImage.draw(w.x, w.y);
                // draw the hitbox
                //g.draw(w.hitbox);

            }
        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta, boolean ground)
            throws SlickException {

        counter += delta;

        Input input = gc.getInput();

        float fdelta = delta * Player.speed;

        Player.setpdelta(fdelta);

        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);

        // System.out.println("Right limit: " + rightlimit);
        float projectedright = Player.x + fdelta + SIZE;

        boolean cangoright = projectedright < rightlimit;

        // there are two types of fixes. A kludge and a hack. This is a kludge.
        //        while (gravity) {
//            Player.y -= 1f;
//        }
        if (isBlocked(Player.x, Player.y + SIZE + delta * 0.1f)) {
            ground = true;
        } else if (isLand(Player.x, Player.y + SIZE + delta * 0.1f)) {
            ground = true;
        } else {
            ground = false;
        }
//        if(ground){
//            jumping = false;
//        }
//        if(jumping){
//            Player.speed = 0.5f;
//        }
//        if (ground && !jumping) {
//            verticalSpeed += .1155f * delta;
//            Player.y += verticalSpeed;
//        }
        counter += delta;

//        float fdelta = delta * Player.speed;
        //Input input = gc.getInput();
        if (!input.isKeyDown(Input.KEY_SPACE) && !Player.rect.intersects(ladderitem1.hitbox)
                && !Player.rect.intersects(ladderitem1.hitbox) && !Player.rect.intersects(ladderitem1.hitbox)
                && !Player.rect.intersects(ladderitem1.hitbox) && !Player.rect.intersects(ladderitem1.hitbox)
                && !Player.rect.intersects(ladderitem1.hitbox) && !Player.rect.intersects(ladderitem1.hitbox)) {
            Player.speed = 0.22f;
//            verticalSpeed = 2;
//            Player.y += verticalSpeed;
//            sprite.update(delta);
            if (!isBlocked(Player.x - 5, Player.y + SIZE + 1 + fdelta)
                    && (!isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta))) {

                sprite.update(delta);

                Player.y += fdelta;

            }
        }

        Player.setpdelta(fdelta);

//        double rightlimit = (grassMap.getWidth() * SIZE) - (SIZE * 0.75);
        // System.out.println("Right limit: " + rightlimit);
//        float projectedright = Player.x + fdelta + SIZE;
//        boolean cangoright = projectedright < rightlimit;
        if (input.isKeyDown(Input.KEY_SPACE)) {
//            Player.speed = 0.35f;
//            float fdsc = (float) (fdelta - (SIZE * 1));
            if (!(isBlocked(Player.x, Player.y - fdelta) || isBlocked((float) (Player.x + SIZE + 1.5), Player.y - fdelta))) {

                sprite.update(delta);
                float verticalSpeed = 0;
                boolean jumping = false;

                // The lower the delta the slower the sprite will animate.
//                Player.y -= fdelta;How do you add an image to a slick game?
                if ((input.isKeyDown(Input.KEY_SPACE)) && !jumping && !(verticalSpeed >= 0)) {
//                    sprite = jump;
//                    System.out.println("jumped??");
                    verticalSpeed = -.6f / 2 * delta;//negative value indicates an upward movement
                    jumping = true;
                }

                if (jumping) {
//                    delta++;
//                    System.out.println("changing vspeed??");
                    verticalSpeed += .08f / 4 * delta;//change this value to alter gravity strength

                    if (ground) {
                        // The lower the delta the slowest the sprite will animate.
//                        System.out.println("idk");
                        Player.y -= delta * 1f / 2;
                        verticalSpeed = 0;
                        jumping = false;

                    }

                }

                if ((ground) && !jumping) {
//                    System.out.println("i am midair");
                    verticalSpeed = -.06f / 2;
                } else if (!(ground) && !jumping) {
//                    System.out.println("im starting a jump");
                    verticalSpeed = -.023f / 2 * delta;
                }
//                if(!isBlocked(Player.x - 5, Player.y + SIZE + 1 + fdelta)
//                    && (!isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta))){
                Player.y += verticalSpeed;

            }
        }
        if (input.isKeyDown(Input.KEY_UP)) {

            sprite = up;
            Iterable<Ladder> ladderlist;
            for (Ladder l : stuff2) {
                /*
                 I initialized the ladderlist here.
                 The reason I'm typing this is so that 
                 if this DOESN'T work, you fix it.
                 */

                if (Player.rect.intersects(l.hitbox)
                        && !(isBlocked(Player.x, Player.y - fdelta) || isBlocked(
                                (float) (Player.x + SIZE + 1.5), Player.y - fdelta))) {
                    sprite.update(delta);

                    // The lower the delta the slower the sprite will animate.
                    Player.y -= fdelta;

                }

            }

        } else if (input.isKeyDown(Input.KEY_DOWN)) {

            sprite = down;

            if (!isBlocked(Player.x - 5, Player.y + SIZE + 1 + fdelta)
                    && (!isBlocked(Player.x + SIZE - 1, Player.y + SIZE + fdelta))) {

                sprite.update(delta);

                Player.y += fdelta;

            }

        }
        if (input.isKeyDown(Input.KEY_LEFT)) {

            sprite = left;

            if (!(isBlocked(Player.x - fdelta, Player.y)
                    || isBlocked(Player.x - fdelta, Player.y + SIZE - 1))) {

                sprite.update(delta);

                Player.x -= fdelta;

            }

        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {

            sprite = right;

            // the boolean-kludge-implementation
            if (cangoright
                    && (!(isBlocked(Player.x + SIZE + fdelta,
                            Player.y) || isBlocked(Player.x + SIZE + fdelta, Player.y
                            + SIZE - 1)))) {

                sprite.update(delta);

                Player.x += fdelta;

            } // else { System.out.println("Right limit reached: " +
            // rightlimit);}

        }
        if (input.isKeyPressed(Input.KEY_DELETE)) {
            Player.health = 0;
        }

        Player.rect.setLocation(Player.getplayershitboxX(),
                Player.getplayershitboxY());

        Player.rect.setLocation(Player.getplayershitboxX(),
                Player.getplayershitboxY());

        for (Item i : stuff) {

            if (Player.rect.intersects(i.hitbox)) {
                //System.out.println("yay");
                if (i.isvisible) {

                    Player.health += 10000;
                    i.isvisible = false;
                }

            }
        }

        for (Sugar h : stuff1) {

            if (Player.rect.intersects(h.hitbox)) {
                //System.out.println("yay");
                if (h.isvisible) {

                    Player.speed += .1f;
                    h.isvisible = false;
                }

            }
        }

        for (Itemwin w : stuffwin) {

            if (Player.rect.intersects(w.hitbox)) {
                //System.out.println("yay");
                if (w.isvisible) {
                    w.isvisible = false;
                    makevisible();
                    sbg.enterState(3, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));

                }

            }
        }

        Player.health -= counter / 1000;
        if (Player.health <= 0) {
            makevisible();
            sbg.enterState(2, new FadeOutTransition(Color.black), new FadeInTransition(Color.black));
        }

    }

    public int getID() {

        return 1;

    }

    public void makevisible() {
        for (Sugar h : stuff1) {

            h.isvisible = true;
        }

        for (Item i : stuff) {

            i.isvisible = true;
        }
    }

    private boolean isBlocked(float tx, float ty) {

        int xBlock = (int) tx / SIZE;

        int yBlock = (int) ty / SIZE;

        return Blocked.Blocked[xBlock][yBlock];

        // this could make a better kludge
    }

    private boolean isLand(float x, float f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
