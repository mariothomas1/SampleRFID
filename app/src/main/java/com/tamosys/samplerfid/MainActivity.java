//Sample using  https://code.tutsplus.com/tutorials/reading-nfc-tags-with-android--mobile-17278 as prototype from 2013

// also checkout https://developer.android.com/guide/topics/connectivity/nfc/nfc.html

package com.tamosys.samplerfid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.nfc.NfcAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "NfcDemo";

    private TextView mTextView;
    private NfcAdapter mNfcAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView_explanation);

        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        if (mNfcAdapter == null) {
            // Stop here, we definitely need NFC
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;

        }

        if (mNfcAdapter.isEnabled()) {
            mTextView.setText(R.string.explanation);
        }
        else {
            mTextView.setText("NFC is disabled.");
        }
        /*
        if (!mNfcAdapter.isEnabled()) {
            mTextView.setText("NFC is disabled.");
        } else {
            mTextView.setText(R.string.explanation);
        }
        */

        handleIntent(getIntent());

    }

    private void handleIntent(Intent intent) {
        // TODO: handle Intent
    }
}
