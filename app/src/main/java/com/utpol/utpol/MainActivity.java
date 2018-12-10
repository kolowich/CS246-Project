package com.utpol.utpol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.parse.Parse;

import java.util.ArrayList;
import java.util.List;

public class
MainActivity extends AppCompatActivity {

    private static LoginValidator login;
    private static HomeScreen home;
    private static final boolean PROTOTYPE = false;
    //private SharedPreferences sharedPreferences = this.getSharedPreferences("utpol", MODE_PRIVATE);
    private static long animationDuration = 1;
    private static ConstraintLayout home_overlay = null;
    private static ConstraintLayout loginView = null;
    private static ConstraintLayout navigationView = null;
    private static ConstraintLayout contact_directory_overlay = null;
    private static ConstraintLayout bill_directory_overlay = null;
    private static ConstraintLayout committee_directory_overlay = null;
    private static ConstraintLayout contact_detail1_overlay = null;
    private ListView contactListView = null;
    private ListView billListView = null;
    private ListView committeeListView = null;
    List<ContactDetail> listContactDetail = new ArrayList<>();
    List<BillDetail> listBillDetail = new ArrayList<>();
    List<CommitteeDetail> listCommitteeDetail = new ArrayList<>();
    private ContactDetail contactDetail;
    private BillDetail billDetail;
    private CommitteeDetail committeeDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String location = sharedPreferences.getString(HomeScreen.LOCATION, "Unknown Location");
        //create the HomeScreen View
        home = new HomeScreen(this, null);
        home_overlay = findViewById(R.id.home_overlay);
        loginView = findViewById(R.id.login_overlay);
        navigationView = findViewById(R.id.navigation_overlay);
        contact_directory_overlay = findViewById(R.id.contact_directory_overlay);
        bill_directory_overlay = findViewById(R.id.bill_directory_overlay);
        committee_directory_overlay = findViewById(R.id.committee_directory_overlay);
        contact_detail1_overlay = findViewById(R.id.contact_detail1_overlay);
        contactListView = findViewById(R.id.contactListView);
        billListView = findViewById(R.id.billListView);
        committeeListView = findViewById(R.id.committeeListView);

        //get the size of the screen/window
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        //translate the forest_overlay off screen without animation before anyone can see it
        home_overlay.setX(size.x);
        navigationView.setX(size.x);
        loginView.setX(new Point(0,0).x);
        contact_directory_overlay.setX(size.x);
        bill_directory_overlay.setX(size.x);
        committee_directory_overlay.setX(size.x);
        contact_detail1_overlay.setX(size.x);

        //initialize the database's information so that we can contact it easily later
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("Qi6kBpZU4OCF3cj11qKtD3CB6FpFY45tHNTtLlj6")
                .clientKey(null)
                .server("https://utpol.herokuapp.com/parse/")
                .build());
    }

    public void login(View view) {
        login = new LoginValidator();

        EditText user = (EditText) findViewById(R.id.editText3);
        EditText pass = (EditText) findViewById(R.id.editText);

        String userName = user.getText().toString();
        String password = pass.getText().toString();

        if(PROTOTYPE) {
            loginView.animate().x(loginView.getWidth()).setDuration(animationDuration);
            showScreen(home_overlay);
        }
        else {
            login.setUsername(userName); //put the editText's string here
            login.setPassword(password); //put the editText's string here

            login.validateUserAndLogIn();

            Toast toast = Toast.makeText(this,"Logging in", (int) 1000);
            toast.show();
        }
    }

    public static void checkValidation() {
        if(login != null && home != null) {
            if (login.isValidated()) {
                loginView.animate().x(loginView.getWidth()).setDuration(animationDuration);
                home_overlay.animate().x(0).setDuration(animationDuration);
                navigationView.animate().x(0).setDuration(animationDuration);
            } else {
                Toast toast = Toast.makeText(home.getContext(),"Username or Password are incorrect", (int) 1000);
                toast.show();
            }
        }
    }
    public LoginValidator getLogin() {
        return login;
    }

    public void setLogin(LoginValidator login) {
        this.login = login;
    }

    public HomeScreen getHome() {
        return home;
    }

    public void setHome(HomeScreen home) {
        this.home = home;
    }


    public void showScreen(ConstraintLayout overlay){
        home_overlay.animate().x(home_overlay.getWidth()).setDuration(animationDuration);
        loginView.animate().x(loginView.getWidth()).setDuration(animationDuration);
        contact_directory_overlay.animate().x(contact_directory_overlay.getWidth()).setDuration(animationDuration);
        bill_directory_overlay.animate().x(bill_directory_overlay.getWidth()).setDuration(animationDuration);
        committee_directory_overlay.animate().x(committee_directory_overlay.getWidth()).setDuration(animationDuration);
        contact_detail1_overlay.animate().x(contact_detail1_overlay.getWidth()).setDuration(animationDuration);


        navigationView.animate().x(0).setDuration(animationDuration);
        overlay.animate().x(0).setDuration(animationDuration);
    }


    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Reset the variables
            contactDetail = null;
            billDetail = null;
            committeeDetail = null;

            // Get the String included in the Intent.
            String ItemName = intent.getStringExtra("text");

            // Figure out if the ItemName is a ContactDetail, BillDetail, or CommitteeDetail.
            for (ContactDetail contact: listContactDetail){
                if(ItemName.contains(contact.getFirstName()) && ItemName.contains(contact.getLastName()) && ItemName.contains(contact.getPhoneNumber())){
                    contactDetail = contact;
                }
            }
            for (BillDetail bill: listBillDetail){
                if(ItemName.contains(bill.getName()) && ItemName.contains(bill.getCommittee().getNameCommittee())){
                    billDetail = bill;
                }
            }
            if(billDetail == null) {
                for (CommitteeDetail committee : listCommitteeDetail) {
                    if (ItemName.contains(committee.getNameCommittee())) {
                        committeeDetail = committee;
                    }
                }
            }

            //Display the specific Detail screen that is needed.
            if(contactDetail != null) {
                // TODO Add the database call here to get the details for the particular contact. The contactDetail should have the basic details.

                showScreen(contact_detail1_overlay);

                // TODO Add the code to display the contact in the various parts of the contact detail screen

            }

            if(billDetail != null) {
                // TODO Add the database call here to get the details for the particular bill. The billDetail should have the basic details.

                //showScreen(bill_detail1_overlay);

                // TODO Add the code to display the contact in the various parts of the contact detail screen
            }

            if(committeeDetail != null) {
                // TODO Add the database call here to get the details for the particular committee. The committeeDetail should have the basic details.

                //showScreen(committee_detail_overlay);

                // TODO Add the code to display the contact in the various parts of the contact detail screen
            }
        }
    };

    public void homeClick(View view) {
        // TODO Get the messages and other pieces needed for home screen display
        showScreen(home_overlay);

    }

    public void contactsClick(View view) {
        // TODO Get the list of contacts from the database and place them in the listContactDetail list

        ListViewLoader customAdapter = new ListViewLoader(this, listContactDetail);
        contactListView.setAdapter(customAdapter);
        showScreen(contact_directory_overlay);
        contactListView.setOnItemClickListener(new OnItemClickListenerListViewItem());
    }

    public void billsClick(View view) {
        // TODO Get the list of bills from the database and place them in the listBillDetail list

        ListViewLoader customAdapter = new ListViewLoader(this, listBillDetail);
        billListView.setAdapter(customAdapter);
        showScreen(bill_directory_overlay);
        billListView.setOnItemClickListener(new OnItemClickListenerListViewItem());
    }

    public void committeeClick(View view) {
        // TODO Get the list of committees from the database and place them in the listCommitteeDetail list

        ListViewLoader customAdapter = new ListViewLoader(this, listCommitteeDetail);
        committeeListView.setAdapter(customAdapter);
        showScreen(committee_directory_overlay);
        committeeListView.setOnItemClickListener(new OnItemClickListenerListViewItem());
    }

    /*
    public SharedPreferences getSharedPreferencesObject() {
        return sharedPreferences;
    }
    */
}
