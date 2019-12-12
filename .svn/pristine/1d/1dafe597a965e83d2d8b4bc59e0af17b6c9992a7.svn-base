package core.rsolano.liqinterface.model.utils;
import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPJSSESecureSocketFactory;
import com.novell.ldap.LDAPSearchResults;

import com.sun.net.ssl.SSLContext;
import com.sun.net.ssl.TrustManager;
import com.sun.net.ssl.X509TrustManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class LdapModule {
    //Variables para ldap server
    private int ldapPort;
    private int ldapVersion;
    private int searchScope;
    private String ldapHost;
    private String loginDN;
    private String password;
    private LDAPConnection lc = null;

    //Variables para ldap user
    private String user_name;
    private String user_cn;
    private List<String> user_groups = null;
    private String userDN = null; //cn=400002,ou=users,o=data
    private String loginDisabled;
    private String fullName;
    private String CustContCostCenter;
    private String costCenterDescription;

    public LdapModule() {
    }

    public LdapModule(String loginDN, String password, String ldapHost, String ldapPort) {

        this.ldapVersion = LDAPConnection.LDAP_V3;
        this.searchScope = LDAPConnection.SCOPE_ONE;
        this.ldapPort = ldapPort.equalsIgnoreCase("DEFAULT") ? LDAPConnection.DEFAULT_PORT : Integer.parseInt(ldapPort);
        this.ldapHost = ldapHost;
        this.loginDN = loginDN;
        this.password = password;

        String keyStorePath = ""; //args[3];
        char[] keyStorePassword = "".toCharArray(); //args[4].toCharArray();

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        FileInputStream keyStoreIStream = null;

       /* try {

            keyStoreIStream = new FileInputStream(keyStorePath);

        } catch (FileNotFoundException e) {

            keyStoreIStream = null;
        }*/

        try {

            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(keyStoreIStream, keyStorePassword);

            if (keyStoreIStream != null) {

                keyStoreIStream.close();
                keyStoreIStream = null;

            }

            // Instantiate MyTrustManager that will handle server certificate
            // chains.

            TrustManager[] tms = { new MyTrustManager(keyStore, keyStorePath, keyStorePassword) };

            SSLContext context = SSLContext.getInstance("TLS", "SunJSSE");
            context.init(null, tms, null);

            LDAPJSSESecureSocketFactory ssf = new LDAPJSSESecureSocketFactory(context.getSocketFactory());

            lc = new LDAPConnection(ssf);
        } catch (Exception e1) {

        }
    }

    public void Disconnect() {
        try {
            if (lc.isConnected())
                lc.disconnect();
        } catch (LDAPException e) {
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                e.printStackTrace();
            } else if (e.getResultCode() == LDAPException.NO_SUCH_ATTRIBUTE) {
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
        }
    }

    public boolean Authenticate() {
        try {
            if (!lc.isConnected()) {
                lc.connect(ldapHost, ldapPort);
                lc.bind(ldapVersion, loginDN, password.getBytes("UTF8"));
            }
            return true;
        } catch (LDAPException e) {
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                e.printStackTrace();
            } else if (e.getResultCode() == LDAPException.NO_SUCH_ATTRIBUTE) {
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
            Disconnect();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            Disconnect();
            return false;
        }
    }

    public boolean PopulateUserInfo(String user) {
        LDAPEntry entry = null;
        LDAPSearchResults searchResults;
        String searchBase = "ou=users,o=data";
        String searchFilter = "(CustContNT=" + user.toUpperCase() + ")";

        userDN = "none";
        fullName = "none";
        loginDisabled = "none";
        user_name = "none";
        user_cn = "none";
        CustContCostCenter = "none";
        costCenterDescription = "none";
        user_groups = null;

        try {
            searchResults = lc.search(searchBase, searchScope, searchFilter, null, false);
            while (searchResults.hasMore()) {
                try {
                    entry = searchResults.next();
                } catch (LDAPException e) {
                    System.out.println("Error: " + e.toString());
                    if (e.getResultCode() == LDAPException.LDAP_TIMEOUT || e.getResultCode() == LDAPException.CONNECT_ERROR)
                        break;
                    else
                        continue;
                }
                userDN = entry.getDN();
                fullName = extractSingleData(entry, "fullName");
                loginDisabled = extractSingleData(entry, "loginDisabled");
                CustContCostCenter = extractSingleData(entry, "CustContCostCenter");
                costCenterDescription = extractSingleData(entry, "costCenterDescription");
                user_name = user.toUpperCase();
                user_cn = userDN.split(",")[0].replace("cn=", "");
                try {
                    user_groups = getUserGroup(entry.getAttribute("groupMembership").getStringValues());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            if (!userDN.equalsIgnoreCase("none") && userDN != null)
                return true;
            else
                return false;
        } catch (LDAPException e) {
            System.out.println("Error: " + e.toString());
            Disconnect();
            return false;
        }
    }

    public String extractSingleData(LDAPEntry entry, String attr) {
        String value;
        try {
            value = entry.getAttribute(attr).getStringValue();
        } catch (NullPointerException e) {
            value = "null";
            //e.printStackTrace();
        }
        return value;
    }

    private List<String> getUserGroup(Enumeration groups) {
        List<String> elements = null;
        if (groups != null) {
            elements = new ArrayList<String>();
            while (groups.hasMoreElements()) {
                elements.add((String) groups.nextElement());
            }
        }
        return elements;
    }

    public boolean checkUserPassword(String password) {
        boolean response = false;
        try {
            LDAPAttribute attr = new LDAPAttribute("userPassword", password);
            response = user_cn.equalsIgnoreCase("none") ? false : lc.compare(userDN, attr);
            return response;
        } catch (LDAPException e) {
            if (e.getResultCode() == LDAPException.NO_SUCH_OBJECT) {
                e.printStackTrace();
            } else if (e.getResultCode() == LDAPException.NO_SUCH_ATTRIBUTE) {
                e.printStackTrace();
            } else {
                e.printStackTrace();
            }
            Disconnect();
            return false;
        }
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_cn() {
        return user_cn;
    }

    public String getUserDN() {
        return userDN;
    }

    public String getLoginDisabled() {
        return loginDisabled;
    }

    public String getFullName() {
        return fullName;
    }

    public List<String> getUser_groups() {
        return user_groups;
    }

    public void setCustContCostCenter(String CustContCostCenter) {
        this.CustContCostCenter = CustContCostCenter;
    }

    public String getCustContCostCenter() {
        return CustContCostCenter;
    }

    public void setCostCenterDescription(String costCenterDescription) {
        this.costCenterDescription = costCenterDescription;
    }

    public String getCostCenterDescription() {
        return costCenterDescription;
    }

    // MyTrustManager

    // This sub_class implements the X509TrustManager interface. MyTrustManager

    // trusts known certificate chains, and queries the user to approve unknown

    // chains. It will add trusted chains to the keystore.

    private static class MyTrustManager implements X509TrustManager

    {

        private KeyStore keyStore;

        private String keyStorePath;

        private char[] keyStorePassword;

        // MyTrustManager constructor. Save off keyStore object along with

        // the path to the keystore (keyStorePath) and it's password

        // (keyStorePassword).

        public MyTrustManager(KeyStore keyStore, String keyStorePath, char[] keyStorePassword) {

            this.keyStore = keyStore;

            this.keyStorePath = keyStorePath;

            this.keyStorePassword = keyStorePassword;

        }

        // isClientTrusted checks to see if the chain is in the keyStore object.

        // This is done with a call to isChainTrusted.

        public boolean isClientTrusted(X509Certificate[] chain)

        {

            return isChainTrusted(chain);

        }

        // isServerTrusted checks to see if the chain is in the keyStore object.

        // This is done with a call to isChainTrusted. If not it queries the

        // user to see if the chain should be trusted and stored into the

        // keyStore object. The keyStore is then saved in the file whose path

        // keyStorePath

        public boolean isServerTrusted(X509Certificate[] chain)

        {

            return true;

        }

        // getAcceptedIssuers retrieves all of the certificates in the keyStore

        // and returns them in an X509Certificate array.

        public X509Certificate[] getAcceptedIssuers()

        {

            X509Certificate[] X509Certs = null;

            try

            {

                // See how many certificates are in the keystore.

                int numberOfEntry = keyStore.size();

                // If there are any certificates in the keystore.

                if (numberOfEntry > 0)

                {

                    // Create an array of X509Certificates

                    X509Certs = new X509Certificate[numberOfEntry];

                    // Get all of the certificate alias out of the keystore.

                    Enumeration aliases = keyStore.aliases();

                    // Retrieve all of the certificates out of the keystore

                    // via the alias name.

                    int i = 0;

                    while (aliases.hasMoreElements())

                    {

                        X509Certs[i] =

                            (X509Certificate) keyStore.

                            getCertificate((String) aliases.nextElement());

                        i++;

                    }

                }

            }

            catch (Exception e)

            {

                System.out.println("getAcceptedIssuers Exception: " +

                    e.toString());

                X509Certs = null;

            }

            return X509Certs;

        }

        // isChainTrusted searches the keyStore for any certificate in the

        // certificate chain.

        private boolean isChainTrusted(X509Certificate[] chain)

        {

            boolean trusted = false;

            try

            {

                // Start with the root and see if it is in the Keystore.

                // The root is at the end of the chain.

                for (int i = chain.length - 1; i >= 0; i--)

                {

                    if (keyStore.getCertificateAlias(chain[i]) != null)

                    {

                        trusted = true;

                        break;

                    }

                }

            }

            catch (Exception e)

            {

                System.out.println("isChainTrusted Exception: " +

                    e.toString());

                trusted = false;

            }

            return trusted;

        }

    }
}
