package com.example.rahulkumar.connectfour;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class menu_screen extends Activity{

    @Override
    protected void onCreate(Bundle saveState){
        super.onCreate(saveState);
        setContentView(R.layout.menu_screen);
        play_game();
    }

    private void play_game(){
        Button playGameButton = (Button)findViewById(R.id.play_game_button);
        playGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent swag = new Intent(menu_screen.this , play_game.class);
                startActivity(swag);
            }
        });

    }


}
