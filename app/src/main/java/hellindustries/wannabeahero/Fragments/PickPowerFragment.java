package hellindustries.wannabeahero.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

import com.labo.kaji.fragmentanimations.MoveAnimation;

import hellindustries.wannabeahero.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PickPowerFragment.PickPowerInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PickPowerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PickPowerFragment extends Fragment implements View.OnClickListener {


    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button strengthBtn;
    private Button backstoryBtn;

    private int selectedChoice;


    private PickPowerInteractionListener mListener;

    public static final int DURATION = 500;
    public static final int DEACTIVATED_BUTTON_ALPHA = 128;
    public static final int ACTIVATED_BUTTON_ALPHA = 255;

    public static final int TURTLE_POWER = 0;
    public static final int LIGHTNING_POWER = 1;
    public static final int FLIGHT_POWER = 2;
    public static final int WEB_SLINGING_POWER = 3;
    public static final int LASER_VISION_POWER = 4;
    public static final int STRENGTH_POWER = 5;

    public PickPowerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment PickPowerFragment.
     */
    public static PickPowerFragment newInstance() {
        PickPowerFragment fragment = new PickPowerFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pick_power, container, false);

        getViewsReferences(view);
        setButtonsListeners(this);

        backstoryBtn.setEnabled(false);
        backstoryBtn.getBackground().setAlpha(DEACTIVATED_BUTTON_ALPHA);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowerInteractionListener) {
            mListener = (PickPowerInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if(getFragmentManager().getBackStackEntryCount() == 2) {
            if(enter) {
                return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
            } else {
                return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
            }
        } else {
            if(enter) {
                return MoveAnimation.create(MoveAnimation.LEFT, enter, DURATION);
            } else {
                return MoveAnimation.create(MoveAnimation.RIGHT, enter, DURATION);
            }
        }

    }

    @Override
    public void onClick(View view) {
        backstoryBtn.setEnabled(true);
        backstoryBtn.getBackground().setAlpha(ACTIVATED_BUTTON_ALPHA);

        Button btn = (Button) view;

        if (btn == turtleBtn) {

            setButtonSelected(btn, R.drawable.turtle_power);
            selectedChoice = TURTLE_POWER;

            setButtonUnselected(lightningBtn, R.drawable.thors_hammer);
            setButtonUnselected(flightBtn, R.drawable.super_man_crest);
            setButtonUnselected(webBtn, R.drawable.spider_web);
            setButtonUnselected(laserBtn, R.drawable.laser_vision);
            setButtonUnselected(strengthBtn, R.drawable.super_strength);

        } else if (btn == lightningBtn) {

            setButtonSelected(btn, R.drawable.thors_hammer);
            selectedChoice = LIGHTNING_POWER;

            setButtonUnselected(turtleBtn, R.drawable.turtle_power);
            setButtonUnselected(flightBtn, R.drawable.super_man_crest);
            setButtonUnselected(webBtn, R.drawable.spider_web);
            setButtonUnselected(laserBtn, R.drawable.laser_vision);
            setButtonUnselected(strengthBtn, R.drawable.super_strength);

        } else if  (btn == flightBtn) {

            setButtonSelected(btn, R.drawable.super_man_crest);
            selectedChoice = FLIGHT_POWER;

            setButtonUnselected(turtleBtn, R.drawable.turtle_power);
            setButtonUnselected(lightningBtn, R.drawable.thors_hammer);
            setButtonUnselected(webBtn, R.drawable.spider_web);
            setButtonUnselected(laserBtn, R.drawable.laser_vision);
            setButtonUnselected(strengthBtn, R.drawable.super_strength);

        } else if (btn == webBtn) {

            setButtonSelected(btn, R.drawable.spider_web);
            selectedChoice = WEB_SLINGING_POWER;

            setButtonUnselected(turtleBtn, R.drawable.turtle_power);
            setButtonUnselected(lightningBtn, R.drawable.thors_hammer);
            setButtonUnselected(flightBtn, R.drawable.super_man_crest);
            setButtonUnselected(laserBtn, R.drawable.laser_vision);
            setButtonUnselected(strengthBtn, R.drawable.super_strength);

        } else if  (btn == laserBtn) {

            setButtonSelected(btn, R.drawable.laser_vision);
            selectedChoice = LASER_VISION_POWER;

            setButtonUnselected(turtleBtn, R.drawable.turtle_power);
            setButtonUnselected(lightningBtn, R.drawable.thors_hammer);
            setButtonUnselected(flightBtn, R.drawable.super_man_crest);
            setButtonUnselected(webBtn, R.drawable.spider_web);
            setButtonUnselected(strengthBtn, R.drawable.super_strength);

        } else if  (btn == strengthBtn) {

            setButtonSelected(btn, R.drawable.super_strength);
            selectedChoice = STRENGTH_POWER;

            setButtonUnselected(turtleBtn, R.drawable.turtle_power);
            setButtonUnselected(lightningBtn, R.drawable.thors_hammer);
            setButtonUnselected(flightBtn, R.drawable.super_man_crest);
            setButtonUnselected(webBtn, R.drawable.spider_web);
            setButtonUnselected(laserBtn, R.drawable.laser_vision);

        } else if (btn == backstoryBtn){
            mListener.PickPowerInteraction(selectedChoice);
        }

    }

    private void setButtonSelected(Button btn, @DrawableRes int drawable){
        btn.setCompoundDrawablesWithIntrinsicBounds(drawable,0,R.drawable.item_selected,0);
    }

    private void setButtonUnselected(Button btn, @DrawableRes int drawable){
        btn.setCompoundDrawablesWithIntrinsicBounds(drawable,0,R.drawable.item_unselected,0);
    }

    private void getViewsReferences(View view) {
        turtleBtn = (Button) view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button) view.findViewById(R.id.lightningBtn);
        flightBtn = (Button) view.findViewById(R.id.flightBtn);
        webBtn = (Button) view.findViewById(R.id.webBtn);
        laserBtn = (Button) view.findViewById(R.id.laserBtn);
        strengthBtn = (Button) view.findViewById(R.id.strengthBtn);
        backstoryBtn = (Button) view.findViewById(R.id.backstoryBtn);
    }

    private void setButtonsListeners(View.OnClickListener listener) {

        turtleBtn.setOnClickListener(listener);
        lightningBtn.setOnClickListener(listener);
        flightBtn.setOnClickListener(listener);
        webBtn.setOnClickListener(listener);
        laserBtn.setOnClickListener(listener);
        strengthBtn.setOnClickListener(listener);
        backstoryBtn.setOnClickListener(listener);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowerInteractionListener {
        void PickPowerInteraction(int selectedChoice);
    }
}
