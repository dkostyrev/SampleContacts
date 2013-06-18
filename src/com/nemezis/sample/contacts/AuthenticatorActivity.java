package com.nemezis.sample.contacts;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;


/**
 * The Authenticator activity.
 *
 * Called by the Authenticator and in charge of identifing the user.
 *
 * It sends back to the Authenticator the result.
 */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    private AccountManager mAccountManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("AuthenticatorActivity");
        Intent res = new Intent();
        res.putExtra(AccountManager.KEY_ACCOUNT_NAME, AccountGeneral.ACCOUNT_NAME);
        res.putExtra(AccountManager.KEY_ACCOUNT_TYPE, AccountGeneral.ACCOUNT_TYPE);
        res.putExtra(AccountManager.KEY_AUTHTOKEN, AccountGeneral.ACCOUNT_TOKEN);
        Account account = new Account(AccountGeneral.ACCOUNT_NAME, AccountGeneral.ACCOUNT_TYPE);
        mAccountManager = AccountManager.get(this);
        mAccountManager.addAccountExplicitly(account, null, null);
        //mAccountManager.setAuthToken(account, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, AccountGeneral.ACCOUNT_TOKEN);
        ContentResolver.setSyncAutomatically(account, ContactsContract.AUTHORITY, true);
        setAccountAuthenticatorResult(res.getExtras());
        setResult(RESULT_OK, res);
        finish();
    }
}
