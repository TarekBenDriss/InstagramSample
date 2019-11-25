package instagram.mpsdm.com.instagram.revision;

import androidx.databinding.Bindable;

import androidx.databinding.BaseObservable;

public class TemperatureData extends BaseObservable {
    private String celsius;

    public TemperatureData(String celsius) {
        this.celsius = celsius;
    }

    @Bindable
    public String getCelsius() {
        return celsius;
    }

    public void setCelsius(String celsius) {
        this.celsius = celsius;
        //notifyPropertyChanged(BR.celsius);
    }
}