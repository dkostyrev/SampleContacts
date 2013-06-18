package com.nemezis.sample.contacts;



import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SampleActivity extends Activity {
	private Intent serviceIntent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		((Button) findViewById(R.id.addContactButton)).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				addNewAccount(AccountGeneral.ACCOUNT_TYPE, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS);
				ContactsManager.addContact(SampleActivity.this, new MyContact("sample", "samplee"));
				/*if (serviceIntent == null)
					serviceIntent = new Intent(SampleActivity.this, ContactUpdateService.class);
				stopService(serviceIntent);
				startService(serviceIntent);
				*/
			}
		});
	}
	
	private void addNewAccount(String accountType, String authTokenType) {
        final AccountManagerFuture<Bundle> future = AccountManager.get(this).addAccount(accountType, authTokenType, null, null, this, new AccountManagerCallback<Bundle>() {
            @Override
            public void run(AccountManagerFuture<Bundle> future) {
                try {
                    Bundle bnd = future.getResult();
                    Log.i("Account was created");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, null);
    }
	
	

}
