package zoba.me.snakesir;

import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 *
 * Created by onlyfu on 11/15/2015.
 */
public class GameHandler extends Handler {

    WeakReference<MainActivity> mainActivity;

    public GameHandler(MainActivity activity) {
        mainActivity = new WeakReference<MainActivity>(activity);
    }

    @Override
    public void handleMessage(Message message) {

        MainActivity thisActivity = mainActivity.get();

        if (message.what == 0x123) {

            thisActivity.gameView.invalidate();
        }
    }
}
