package com.example.snippy.battleships;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

class IntPair {
    int x, y;
    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    }

public class MainActivity extends AppCompatActivity {

    Game game;
    Renderer r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = (Renderer) findViewById(R.id.Renderer);
        game = new Game();

//        r.setGameStateProvider(game.getCurrentPlayer().getCurrentState());
    }


}
