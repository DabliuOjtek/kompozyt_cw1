import java.util.ArrayList;

class Katalogi extends Component
{
    protected ArrayList<Component> skladowe = new ArrayList();

    public Katalogi(String nazwa)
    {
        super(nazwa);
    }

    public void dodaj( Component cmp )
    {
        cmp.poprzednia = this;
        skladowe.add( cmp );
    }

    @Override
    protected boolean jestPlikiem() {
        return false;
    }

    @Override
    public void dir() {
        System.out.println("Directory of "+nazwa);
            for (Component s: skladowe){
                if(s.jestPlikiem()==false){
                    System.out.println("    "+s.nazwa);
                }else
                    s.dir();
        }
    }

    @Override
    public int cd(String nazwaKatalogu) {
        for(Component s: skladowe) {
            if (s.nazwa.equals(nazwaKatalogu)){
                return skladowe.indexOf(s);
            }
        }
        return -2;
    }

}
