

package complaintmanagement;

import java.sql.Date;



public class clsaccprp
{
    private int accno;
    private String accnam,accadd,accloc,accphnno,acctyp;
    Date  accrtdat;

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getAccnam() {
        return accnam;
    }

    public void setAccnam(String accnam) {
        this.accnam = accnam;
    }

    public String getAccadd() {
        return accadd;
    }

    public void setAccadd(String accadd) {
        this.accadd = accadd;
    }

    public String getAccloc() {
        return accloc;
    }

    public void setAccloc(String accloc) {
        this.accloc = accloc;
    }

    public String getAccphnno() {
        return accphnno;
    }

    public void setAccphnno(String accphnno) {
        this.accphnno = accphnno;
    }

    public String getAcctyp() {
        return acctyp;
    }

    public void setAcctyp(String acctyp) {
        this.acctyp = acctyp;
    }

    public Date getAccrtdat() {
        return accrtdat;
    }

    public void setAccrtdat(Date accrtdat) {
        this.accrtdat = accrtdat;
    }
    
    
}
