class Pliki extends Component
{
    protected String rozszerzenie;

    public Pliki(String nazwa, String rozszerzenie) {
        super( nazwa );
        this.rozszerzenie = rozszerzenie;
    }

    @Override
    protected boolean jestPlikiem() {
        return true;
    }

    @Override
    public void dir() {
        System.out.println("    " + nazwa + rozszerzenie);
    }

    @Override
    public int cd(String nazwaKat){
        return -2;
    }
}

