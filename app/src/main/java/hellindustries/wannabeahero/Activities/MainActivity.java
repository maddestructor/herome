package hellindustries.wannabeahero.Activities;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hellindustries.wannabeahero.Fragments.MainFragment;
import hellindustries.wannabeahero.Fragments.PickPowerFragment;
import hellindustries.wannabeahero.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener, PickPowerFragment.PickPowerInteractionListener {

    private int powerAcquisitionChoice;
    private int mainPowerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = MainFragment.newInstance();
            fm.beginTransaction().add(R.id.fragment_container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }


    @Override
    public void onMainFragmentInteraction(int powerAcquisitionChoice) {
        this.powerAcquisitionChoice = powerAcquisitionChoice;
        PickPowerFragment pickPowerFragment = PickPowerFragment.newInstance();
        getSupportFragmentManager().beginTransaction().addToBackStack(null)
                .replace(R.id.fragment_container, pickPowerFragment)
                .commit();
    }

    @Override
    public void PickPowerInteraction(int mainPowerChoice) {
        this.mainPowerChoice = mainPowerChoice;

    }
}
