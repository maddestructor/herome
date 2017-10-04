package hellindustries.wannabeahero.Activities;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import hellindustries.wannabeahero.Fragments.BackStoryFragment;
import hellindustries.wannabeahero.Fragments.MainFragment;
import hellindustries.wannabeahero.Fragments.PickPowerFragment;
import hellindustries.wannabeahero.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener, PickPowerFragment.OnPickPowerInteractionListener, BackStoryFragment.OnStartOverInteractionListener {

    private int powerAcquisitionChoice;
    private int mainPowerChoice;

    public final static String FIRST_FRAGMENT_TRANSACTION = "First fragment transaction";

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

        pickPowerFragment.setPreviousFragment(PickPowerFragment.PREVIOUS_MAIN_FRAGMENT);

        getSupportFragmentManager().beginTransaction().addToBackStack(FIRST_FRAGMENT_TRANSACTION)
                .replace(R.id.fragment_container, pickPowerFragment)
                .commit();
    }

    @Override
    public void onPickPowerInteraction(int mainPowerChoice, @Nullable PickPowerFragment pickPowerFragment) {
        this.mainPowerChoice = mainPowerChoice;
        BackStoryFragment backStoryFragment = BackStoryFragment.newInstance(powerAcquisitionChoice, mainPowerChoice);

        if(pickPowerFragment != null){
            pickPowerFragment.setPreviousFragment(PickPowerFragment.PREVIOUS_BACKSTORY_FRAGMENT);
        }

        getSupportFragmentManager().beginTransaction().addToBackStack(null)
                .replace(R.id.fragment_container, backStoryFragment)
                .commit();
    }

    @Override
    public void onStartOverInteraction() {

        getSupportFragmentManager().popBackStack(FIRST_FRAGMENT_TRANSACTION, FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

}
