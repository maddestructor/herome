package hellindustries.wannabeahero.Activities;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hellindustries.wannabeahero.Fragments.MainFragment;
import hellindustries.wannabeahero.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
