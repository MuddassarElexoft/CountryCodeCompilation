package com.example.countrycodecompilation.data.utils

import android.content.Context
import android.telephony.TelephonyManager
import androidx.compose.ui.text.intl.Locale
import com.example.countrycodecompilation.data.CountryData

fun getDefaultLangCode(context: Context): String {
    val localeCode: TelephonyManager =
        context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    val countryCode = localeCode.networkCountryIso
    val defaultLocale = Locale.current.language
    return countryCode.ifBlank { defaultLocale }
}

fun getDefaultPhoneCode(context: Context): String {
    val defaultCountry = getDefaultLangCode(context)
    val defaultCode: CountryData = getLibCountries.first { it.countryCode == defaultCountry }
    return defaultCode.countryPhoneCode.ifBlank { "+90" }
}

