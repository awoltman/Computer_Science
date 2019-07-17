from pymodbus.client.sync import ModbusTcpClient as ModbusClient
import matplotlib.pyplot as plt
from datetime import datetime
import sqlite3
import time
import pymysql

def connect_aws():
    host = "wimsa.cqlijjz0dvla.us-east-2.rds.amazonaws.com"
    port = 3306
    dbname = "wimsa"
    user = "wimsa"
    password = "Manitowoc2019"
    awsinfo = [host,user,password,port,dbname]
    return awsinfo
regiserMap = [3,4,5,6,7,9,8,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,63,64,65,66,67,68,69,70,71,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,94,95,96,97,98,99,100,101,102,103,108,109,110,111,112,113,114,115,116,117,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,501,502,503,504,505,506,507,508,509,510,511,512,513,514,515,516,517,518,519,520,521,522,523,524,525,526,527,528,529,530,531,532,533,534,535,536,537,538,539,540,541,542,543,544,545,546,547,550,551,552,553,554,555,556,557,558,559,560,561,562,563,564,565,566,567,568,569,570,571,572,573,574,575,576,577,578,579,580,581,582,583,584,585,586,587,588,589,590,591,592,593,594]
test = '10.81.7.195'
machines = []
'''
UNIT = 0x01
client = ModbusClient(mesthod = 'tcp', host = '10.81.7.195', port = 8899)
sn_current = "".join(hex(x) for x in client.read_holding_registers(93,10,unit = UNIT).registers)
new_sn = sn_current.split("0x")
int_sn = "".join(str((int(x)-30)) for x in new_sn if (x != ''))
store_sn = []
'''
def create_machine_table(ser_num, macaddress):
    UNIT = 0x01
    ## Initialized a table when an ice machine is added to IceMachine table
    hostval =test
    client = ModbusClient(mesthod = 'tcp', host = hostval, port = 8899)
    sn_current = "".join(hex(x) for x in client.read_holding_registers(93,10,unit = UNIT).registers)
    new_sn = sn_current.split("0x")
    int_sn = "".join(str((int(x)-30)) for x in new_sn if (x != ''))
    print (ser_num,int_sn)
    if (ser_num == int_sn):
        machines.append(ser_num)
        info = connect_aws()
        print (info)
        conn = pymysql.connect(host = info[0],user = info[1],password = info[2],port = info[3],database = info[4])
        c = conn.cursor()
        c.execute("CREATE TABLE ser_num ('Time', 'HR_SYSTEM_STATE','HR_LAST_FREEZE_TIME','HR_LAST_HARVEST_TIME','HR_WATER_FILL_TIME','HR_T1_TEMPERATURE','HR_T3_TEMPERATURE','HR_T2_TEMPERATURE','HR_T4_TEMPERATURE','HR_WLP_STATE_HIGH','HR_WLP_STATE_LOW','HR_WATER_CONDUCTIVITY','HR_ITP_STATE','HR_ITP_FFT_50HZ','HR_ITP_THRESHOLD_50HZ','HR_ITP_FFT_100HZ','HR_ITP_THRESHOLD_100HZ','HR_ITP_FFT_150HZ','HR_ITP_THRESHOLD_150HZ','HR_ITP_FFT_200HZ','HR_ITP_THRESHOLD_200HZ','HR_ITP_FFT_60HZ','HR_ITP_THRESHOLD_60HZ','HR_ITP_FFT_120HZ','HR_ITP_THRESHOLD_120HZ','HR_ITP_FFT_180HZ','HR_ITP_THRESHOLD_180HZ','HR_ITP_FFT_240HZ','HR_ITP_THRESHOLD_240HZ','HR_LEFT_CURTAIN_SW_STATE','HR_RIGHT_CURTAIN_SW_STATE)','HR_BIN_TEMPERATURE1','HR_BIN_TEMPERATURE2','HR_BIN_TEMPERATURE3','HR_FFT_6MIN_AVERAGE','HR_HPCO_STATE','HR_LPCO_STATE','HR_HPCO_COUNT_24HOURS','HR_LPCO_COUNT_24HOURS','HR_SAFETY_LIMIT_1','HR_SAFETY_LIMIT_2','HR_SOFTWARE_VER_MAJOR','HR_SOFTWARE_VER_MINOR','HR_DISPLAY_SOFTWARE_VER_MAJOR','HR_DISPLAY_SOFTWARE_VER_MINOR','HR_BIN_LEVEL_SETTING','HR_BIN_LEVEL_RUN_ENABLE','HR_ICE_CLARITY_ENABLE','HR_WATER_MISER_ENABLE','HR_AIR_FILTER_MINDER_ENABLE','HR_AIR_FILTER_INTERVAL','HR_CLEAN_MINDER_ENABLE','HR_CLEAN_MINDER_INTERVAL','HR_WATER_FILTER_SETTING','HR_WATER_FILTER_INTERVAL','HR_CLEAN_CYCLES_PER_24HOURS','HR_DATE_FORMAT_SETTING','HR_TIME_FORMAT_SETTING','HR_RESET_REGISTER','HR_LIFETIME_CLEAN_CYCLES','HR_SELF_CLEAN_INTERVAL','SIGNATURE_BYTE_ADDRESS','HR_MODEL_NUM_CHAR_1','HR_MODEL_NUM_CHAR_2','HR_MODEL_NUM_CHAR_3','HR_MODEL_NUM_CHAR_4','HR_MODEL_NUM_CHAR_5','HR_MODEL_NUM_CHAR_6','HR_MODEL_NUM_CHAR_7','HR_MODEL_NUM_CHAR_8','HR_MODEL_NUM_CHAR_9','HR_MODEL_NUM_CHAR_10','HR_MODEL_NUM_CHAR_11','HR_SERIAL_NUM_CHAR_1','HR_SERIAL_NUM_CHAR_2','HR_SERIAL_NUM_CHAR_3','HR_SERIAL_NUM_CHAR_4','HR_SERIAL_NUM_CHAR_5','HR_SERIAL_NUM_CHAR_6','HR_SERIAL_NUM_CHAR_7','HR_SERIAL_NUM_CHAR_8','HR_SERIAL_NUM_CHAR_9','HR_SERIAL_NUM_CHAR_10','HR_CONDENSER_SER_NUM_CHAR_1','HR_CONDENSER_SER_NUM_CHAR_2','HR_CONDENSER_SER_NUM_CHAR_3','HR_CONDENSER_SER_NUM_CHAR_4','HR_CONDENSER_SER_NUM_CHAR_5','HR_CONDENSER_SER_NUM_CHAR_6','HR_CONDENSER_SER_NUM_CHAR_7','HR_CONDENSER_SER_NUM_CHAR_8','HR_CONDENSER_SER_NUM_CHAR_9','HR_CONDENSER_SER_NUM_CHAR_10','HR_MACHINE_MANUFACTURER_SEC_HIGH','HR_MACHINE_MANUFACTURER_SEC_LOW','HR_PCB_MANUFACTURER_SEC_HIGH','HR_PCB_MANUFACTURER_SEC_LOW','HR_WARRANTY_TIME_REMAINING_DAYS','HR_CAPACITY_90_70','HR_SLAB_WEIGHT_ONES','HR_SLAB_WEIGHT_THOUSANDTHS','HR_GALLONS_WATER_PER_CYCLE_ONES','HR_GALLONS_WATER_PER_CYCLE_THOUSANDTHS','HR_LIFETIME_RUNTIME_HIGH_BYTE','HR_LIFETIME_RUNTIME_LOW_BYTE','HR_LIFETIME_CYCLE_COUNT_HIGH_BYTE','HR_LIFETIME_CYCLE_COUNT_LOW_BYTE','HR_MIN_FREEZE_TIME_24HOURS','HR_MAX_FREEZE_TIME_24HOURS','HR_AVG_FREEZE_TIME_24HOURS','HR_MIN_HARVEST_TIME_24HOURS','HR_MAX_HARVEST_TIME_24HOURS','HR_AVG_HARVEST_TIME_24HOURS','HR_BIN_FULL_COUNT_24HOURS','HR_CYCLES_PER_24HOURS','HR_ICE_WEIGHT_24HOURS','HR_WATER_USE_24HOURS','HR_MIN_T1_TEMP_24HOURS','HR_MAX_T1_TEMP_24HOURS','HR_MIN_T2_TEMP_24HOURS','HR_MAX_T2_TEMP_24HOURS','HR_MIN_T3_TEMP_24HOURS','HR_MAX_T3_TEMP_24HOURS','HR_MIN_T4_TEMP_24HOURS','HR_MAX_T4_TEMP_24HOURS','HR_MIN_FREEZE_CYCLE_T1','HR_MIN_FREEZE_CYCLE_T2','HR_MIN_FREEZE_CYCLE_T3','HR_MIN_FREEZE_CYCLE_T4','HR_MAX_FREEZE_CYCLE_T1','HR_MAX_FREEZE_CYCLE_T2','HR_MAX_FREEZE_CYCLE_T3','HR_MAX_FREEZE_CYCLE_T4','HR_MIN_HARVEST_CYCLE_T1','HR_MIN_HARVEST_CYCLE_T2','HR_MIN_HARVEST_CYCLE_T3','HR_MIN_HARVEST_CYCLE_T4','HR_MAX_HARVEST_CYCLE_T1','HR_MAX_HARVEST_CYCLE_T2','HR_MAX_HARVEST_CYCLE_T3','HR_MAX_HARVEST_CYCLE_T4,'HR_E01_COUNT_HIGH_BYTE','HR_E01_COUNT_LOW_BYTE','HR_E01_TIMESTAMP_HIGH_BYTE','HR_E01_TIMESTAMP_LOW_BYTE','HR_E02_COUNT_HIGH_BYTE','HR_E02_COUNT_LOW_BYTE','HR_E02_TIMESTAMP_HIGH_BYTE','HR_E02_TIMESTAMP_LOW_BYTE','HR_E03_COUNT_HIGH_BYTE','HR_E03_COUNT_LOW_BYTE','HR_E03_TIMESTAMP_HIGH_BYTE','HR_E03_TIMESTAMP_LOW_BYTE','HR_E04_COUNT_HIGH_BYTE','HR_E04_COUNT_LOW_BYTE','HR_E04_TIMESTAMP_HIGH_BYTE','HR_E04_TIMESTAMP_LOW_BYTE','HR_E05_COUNT_HIGH_BYTE','HR_E05_COUNT_LOW_BYTE','HR_E05_TIMESTAMP_HIGH_BYTE','HR_E05_TIMESTAMP_LOW_BYTE','HR_E06_COUNT_HIGH_BYTE','HR_E06_COUNT_LOW_BYTE','HR_E06_TIMESTAMP_HIGH_BYTE','HR_E06_TIMESTAMP_LOW_BYTE','HR_E07_COUNT_HIGH_BYTE','HR_E07_COUNT_LOW_BYTE','HR_E07_TIMESTAMP_HIGH_BYTE','HR_E07_TIMESTAMP_LOW_BYTE','HR_E08_COUNT_HIGH_BYTE','HR_E08_COUNT_LOW_BYTE','HR_E08_TIMESTAMP_HIGH_BYTE','HR_E08_TIMESTAMP_LOW_BYTE','HR_E09_COUNT_HIGH_BYTE','HR_E09_COUNT_LOW_BYTE','HR_E09_TIMESTAMP_HIGH_BYTE','HR_E09_TIMESTAMP_LOW_BYTE','HR_E10_COUNT_HIGH_BYTE','HR_E10_COUNT_LOW_BYTE','HR_E10_TIMESTAMP_HIGH_BYTE','HR_E10_TIMESTAMP_LOW_BYTE','HR_E11_COUNT_HIGH_BYTE','HR_E11_COUNT_LOW_BYTE','HR_E11_TIMESTAMP_HIGH_BYTE','HR_E11_TIMESTAMP_LOW_BYTE','HR_E12_COUNT_HIGH_BYTE','HR_E12_COUNT_LOW_BYTE','HR_E12_TIMESTAMP_HIGH_BYTE','HR_E12_TIMESTAMP_LOW_BYTE','HR_E13_COUNT_HIGH_BYTE','HR_E13_COUNT_LOW_BYTE','HR_E13_TIMESTAMP_HIGH_BYTE','HR_E13_TIMESTAMP_LOW_BYTE','HR_E14_COUNT_HIGH_BYTE','HR_E14_COUNT_LOW_BYTE','HR_E14_TIMESTAMP_HIGH_BYTE','HR_E14_TIMESTAMP_LOW_BYTE','HR_E15_COUNT_HIGH_BYTE','HR_E15_COUNT_LOW_BYTE','HR_E15_TIMESTAMP_HIGH_BYTE','HR_E15_TIMESTAMP_LOW_BYTE','HR_E16_COUNT_HIGH_BYTE','HR_E16_COUNT_LOW_BYTE','HR_E16_TIMESTAMP_HIGH_BYTE','HR_E16_TIMESTAMP_LOW_BYTE','HR_E17_COUNT_HIGH_BYTE','HR_E17_COUNT_LOW_BYTE','HR_E17_TIMESTAMP_HIGH_BYTE','HR_E17_TIMESTAMP_LOW_BYTE','HR_E18_COUNT_HIGH_BYTE','HR_E18_COUNT_LOW_BYTE','HR_E18_TIMESTAMP_HIGH_BYTE','HR_E18_TIMESTAMP_LOW_BYTE','HR_E19_COUNT_HIGH_BYTE','HR_E19_COUNT_LOW_BYTE','HR_E19_TIMESTAMP_HIGH_BYTE','HR_E19_TIMESTAMP_LOW_BYTE','HR_E20_COUNT_HIGH_BYTE','HR_E20_COUNT_LOW_BYTE','HR_E20_TIMESTAMP_HIGH_BYTE','HR_E20_TIMESTAMP_LOW_BYTE','HR_E21_COUNT_HIGH_BYTE','HR_E21_COUNT_LOW_BYTE','HR_E21_TIMESTAMP_HIGH_BYTE','HR_E21_TIMESTAMP_LOW_BYTE','HR_E22_COUNT_HIGH_BYTE','HR_E22_COUNT_LOW_BYTE','HR_E22_TIMESTAMP_HIGH_BYTE','HR_E22_TIMESTAMP_LOW_BYTE','HR_E23_COUNT_HIGH_BYTE','HR_E23_COUNT_LOW_BYTE','HR_E23_TIMESTAMP_HIGH_BYTE','HR_E23_TIMESTAMP_LOW_BYTE','HR_E24_COUNT_HIGH_BYTE','HR_E24_COUNT_LOW_BYTE','HR_E24_TIMESTAMP_HIGH_BYTE','HR_E24_TIMESTAMP_LOW_BYTE','HR_E25_COUNT_HIGH_BYTE','HR_E25_COUNT_LOW_BYTE','HR_E25_TIMESTAMP_HIGH_BYTE','HR_E25_TIMESTAMP_LOW_BYTE','HR_E26_COUNT_HIGH_BYTE','HR_E26_TIMESTAMP_HIGH_BYTE','HR_E26_TIMESTAMP_LOW_BYTE','HR_E27_COUNT_HIGH_BYTE','HR_E27_COUNT_LOW_BYTE','HR_E27_TIMESTAMP_HIGH_BYTE','HR_E27_TIMESTAMP_LOW_BYTE','HR_E28_COUNT_HIGH_BYTE','HR_E28_COUNT_LOW_BYTE','HR_E28_TIMESTAMP_HIGH_BYTE','HR_E28_TIMESTAMP_LOW_BYTE','HR_E29_COUNT_HIGH_BYTE','HR_E29_COUNT_LOW_BYTE','HR_E29_TIMESTAMP_HIGH_BYTE','HR_E29_TIMESTAMP_LOW_BYTE','HR_E30_COUNT_HIGH_BYTE','HR_E30_COUNT_LOW_BYTE','HR_E30_TIMESTAMP_HIGH_BYTE','HR_E30_TIMESTAMP_LOW_BYTE','HR_E31_COUNT_HIGH_BYTE','HR_E31_COUNT_LOW_BYTE','HR_E31_TIMESTAMP_HIGH_BYTE','HR_E31_TIMESTAMP_LOW_BYTE','HR_E32_COUNT_HIGH_BYTE','HR_E32_COUNT_LOW_BYTE','HR_E32_TIMESTAMP_HIGH_BYTE','HR_E32_TIMESTAMP_LOW_BYTE','HR_E33_COUNT_HIGH_BYTE','HR_E33_COUNT_LOW_BYTE','HR_E33_TIMESTAMP_HIGH_BYTE','HR_E33_TIMESTAMP_LOW_BYTE','HR_E34_COUNT_HIGH_BYTE','HR_E34_COUNT_LOW_BYTE','HR_E34_TIMESTAMP_HIGH_BYTE','HR_E34_TIMESTAMP_LOW_BYTE','HR_E35_COUNT_HIGH_BYTE','HR_E35_COUNT_LOW_BYTE','HR_E35_TIMESTAMP_HIGH_BYTE','HR_E35_TIMESTAMP_LOW_BYTE','HR_E36_COUNT_HIGH_BYTE','HR_E36_COUNT_LOW_BYTE','HR_E36_TIMESTAMP_HIGH_BYTE','HR_E36_TIMESTAMP_LOW_BYTE','HR_E37_COUNT_HIGH_BYTE','HR_E37_COUNT_LOW_BYTE','HR_E37_TIMESTAMP_HIGH_BYTE','HR_E37_TIMESTAMP_LOW_BYTE','HR_E38_COUNT_HIGH_BYTE','HR_E38_COUNT_LOW_BYTE','HR_E38_TIMESTAMP_HIGH_BYTE','HR_E38_TIMESTAMP_LOW_BYTE','HR_PROGRAM_MODE_ENABLE','HR_LANGUAGE','HR_DAYLIGHT_SAVINGS','HR_UNITS_TEMPERATURE','HR_UNITS_WEIGHTS','HR_UNITS_OF_VOLUME','HR_LCD_BRIGHTNESS','HR_SCREEN_SAVER','HR_AUCS_ENABLE','HR_AUCS_INTERVAL','HR_WATER_FILTER_TYPE','HR_IONIC_MINDER','HR_ON_TIME_1','HR_ON_TIME_2','HR_ON_TIME_3','HR_ON_TIME_4','HR_ON_TIME_5','HR_ON_TIME_6','HR_ON_TIME_7','HR_OFF_TIME_1','HR_OFF_TIME_2','HR_OFF_TIME_3','HR_OFF_TIME_4','HR_OFF_TIME_5','HR_OFF_TIME_6','HR_OFF_TIME_7','HR_ICE_MAKE_ON_OFF','HR_MANUAL_HARVEST','HR_CLEAN_CYCLE','HR_PROGRAM_BYPASS','HR_ACTIVATION_YEAR','HR_ACTIVATION_MONTH','HR_ACTIVATION_DAY','HR_MCC_AUTO_ICE_STATE','HR_LUMINICE1','HR_LUMINICE2','HR_AUCS_PRESENT','HR_T6_PRESENT','HR_T7_PRESENT','HR_AUCS_CLEAN_SUBSTATE','HR_MCC_CLEAN_SUBSTATE','HR_AUCS_TIMER','HR_MCC_TIMER','HR_READ_SERVICE_DATA_DAY1','HR_READ_SERVICE_DATA_DAY2','HR_READ_SERVICE_DATA_DAY3','HR_READ_SERVICE_DATA_DAY4','HR_READ_SERVICE_DATA_DAY5','HR_READ_OLD_FREEZE_MIN_T1','HR_READ_OLD_FREEZE_MIN_T2','HR_READ_OLD_FREEZE_MIN_T3','HR_READ_OLD_FREEZE_MIN_T4','HR_READ_OLD_FREEZE_MAX_T1','HR_READ_OLD_FREEZE_MAX_T2','HR_READ_OLD_FREEZE_MAX_T3','HR_READ_OLD_FREEZE_MAX_T4','HR_READ_OLD_HARVEST_MIN_T1','HR_READ_OLD_HARVEST_MIN_T2','HR_READ_OLD_HARVEST_MIN_T3','HR_READ_OLD_HARVEST_MIN_T4','HR_READ_OLD_HARVEST_MAX_T1','HR_READ_OLD_HARVEST_MAX_T2','HR_READ_OLD_HARVEST_MAX_T3','HR_READ_OLD_HARVEST_MAX_T4','HR_READ_OLD_RUN_TIME_24HRS','HR_READ_OLD_ICE_WEIGHT_24HRS','HR_READ_OLD_ICE_CYCLE_CNT_24HRS','HR_READ_OLD_POTABLE_H2O_24HRS','HR_READ_OLD_CLEAN_CYCLES_24HRS','HR_SET_MINDER_TIME_AIR_FILTER','HR_SET_MINDER_TIME_WATER_FILTER','HR_SET_MINDER_TIME_IONIC','HR_SET_MINDER_TIME_CLEAN','HR_SET_MINDER_TIME_AUCS_CLEAN','HR_SET_MINDER_FILTER_GALLONS','HR_SET_MINDER_SANITIZE','HR_SANITIZE_MINDER_ENABLE','HR_SANITIZE_MINDER_INTERVAL','HR_RESET_FACTORY_DEFAULTS','HR_PURGE_TIME','HR_ABORT_MCC','HR_ICE_USAGE_DAY1','HR_ICE_USAGE_DAY2','HR_ICE_USAGE_DAY3','HR_ICE_USAGE_DAY4','HR_ICE_USAGE_DAY5','HR_ICE_USAGE_DAY6','HR_ICE_USAGE_DAY7','HR_POTABLE_DAY1','HR_POTABLE_DAY2','HR_POTABLE_DAY3','HR_POTABLE_DAY4','HR_POTABLE_DAY5','HR_CALC_KW_DAY1','HR_CALC_KW_DAY2','HR_CALC_KW_DAY3','HR_CALC_KW_DAY4','HR_CALC_KW_DAY5','HR_UPDATE_FILE_SIZE','HR_FILE_SIZE_HI_FW','HR_FILE_SIZE_LO_FW','HR_ICE_PRODUCTION_DAY1','HR_ICE_PRODUCTION_DAY2','HR_ICE_PRODUCTION_DAY3','HR_ICE_PRODUCTION_DAY4','HR_ICE_PRODUCTION_DAY5','HR_PROCESS_PERCENT','HR_MIN_HARVEST_TIMESTAMP_SEC_HIGH','HR_MIN_HARVEST_TIMESTAMP_SEC_LOW','HR_MAX_HARVEST_TIMESTAMP_SEC_HIGH','HR_MAX_HARVEST_TIMESTAMP_SEC_LOW','HR_MIN_FREEZE_TIMESTAMP_SEC_HIGH','HR_MIN_FREEZE_TIMESTAMP_SEC_LOW','HR_MAX_FREEZE_TIMESTAMP_SEC_HIGH','HR_MAX_FREEZE_TIMESTAMP_SEC_LOW','HR_CLEAR_ALL_ALERTS','HR_SET_ALERT','HR_CLEAR_ALERT','HR_FORCE_AUCS_PUMP','HR_RELAY_OUTPUT_STATUS','HR_LIFETIME_POTABLE','HR_IS_MODEL_NUM_VALID','HR_LUMINICE_UNIT_STATUS','HR_UI_FILE_EXIST_FLAGS','LOAD_FIRMWARE','HR_MAILBOX_FLAGS','HR_DISPLAY_COMM_STATUS','HR_WIZARD_STATUS','HR_DISPLAY_SOFTWARE_VER_SUB_MINOR','HR_CB_SELF_CHECK,HR_ANY_ALERTS','HR_SERVICE_RELAY_TEST','HR_VERIFY_BOOTLOAD_FILES_IN_USB','HR_READ_SERVICE_DATA_DAY6','HR_READ_SERVICE_DATA_DAY7','HR_POTABLE_DAY6','HR_POTABLE_DAY7','HR_CALC_KW_DAY6','HR_CALC_KW_DAY7','HR_ICE_PRODUCTION_DAY6','HR_ICE_PRODUCTION_DAY7','HR_PROGRAM_MODE_TIME_MIN_LEFT','HR_OLD_DATA_TIME_STAMP_DAY1_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY1_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY2_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY2_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY3_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY3_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY4_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY4_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY5_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY5_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY6_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY6_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY7_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY7_LO_WORD','HR_ELAPSED_TIME_SECONDS','HR_OLD_MIN_HARVEST_TIMESTAMP_SEC_HIGH','HR_OLD_MIN_HARVEST_TIMESTAMP_SEC_LOW','HR_OLD_MAX_HARVEST_TIMESTAMP_SEC_HIGH','HR_OLD_MAX_HARVEST_TIMESTAMP_SEC_LOW','HR_OLD_MIN_FREEZE_TIMESTAMP_SEC_HIGH','HR_OLD_MIN_FREEZE_TIMESTAMP_SEC_LOW','HR_OLD_MAX_FREEZE_TIMESTAMP_SEC_HIGH','HR_OLD_MAX_FREEZE_TIMESTAMP_SEC_LOW','HR_OLD_MIN_FREEZE_TIME_24HOURS','HR_OLD_MAX_FREEZE_TIME_24HOURS','HR_OLD_MIN_HARVEST_TIME_24HOURS','HR_OLD_MAX_HARVEST_TIME_24HOURS','HR_DUMP_TIME','HR_ITP_VIB_ENABLE','HR_ITP_FFT_1KHZ','HR_1KHZ_THRESHOLD','HR_FREQ_REG_1','HR_FREQ_REG_2','HR_FREQ_REG_3','HR_FREQ_REG_4','HR_FREQ_REG_5','HR_FREQ_REG_6','HR_FREQ_REG_7','HR_FREQ_REG_8','HR_FREQ_REG_9','HR_FREQ_REG_10','HR_ACOUSTIC_ACTUATOR_CYCLE_COUNTS','HR_ACOUSTIC_ACTUATOR_LIFETIME_COUNTS','HR_FREEZE_IN_CHECK_FAIL_COUNTS','HR_THAW_BYPASS_VARIABLE','HR_FREEZE_TIME_20_SMPL_MEAN','HR_FREEZE_TIME_20_SMPL_MEDIAN','HR_FREEZE_TIME_20_SMPL_STD_DEV','HR_FREEZE_TIME_20_SMPL_RANGE','HR_TARGET_FREEZE_TIME_PREDICTION','HR_NORMALITY_q','HR_ACTIVE_SENSE_ENABLE_STATUS','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_CNT_HIGH_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_CNT_LOW_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_TIMESTAMP_HIGH_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_TIMESTAMP_LOW_BYTE','HR_FREEZE_TIME1','HR_FREEZE_TIME2','HR_FREEZE_TIME3','HR_FREEZE_TIME4','HR_FREEZE_TIME5','HR_FREEZE_TIME6','HR_FREEZE_TIME7','HR_FREEZE_TIME8','HR_FREEZE_TIME9','HR_FREEZE_TIME10','HR_FREEZE_TIME11','HR_FREEZE_TIME12','HR_FREEZE_TIME13','HR_FREEZE_TIME14','HR_FREEZE_TIME15','HR_FREEZE_TIME16','HR_FREEZE_TIME17','HR_FREEZE_TIME18','HR_FREEZE_TIME19','HR_FREEZE_TIME20'")
        return 'table created'
    else:
        return 'Given serial number and Machine serial number do not match'

def enter_data(ser_num,machines):
    info = connect_aws()
    conn = sqlite3.connect(host = info[0],port = info[1],database = info[2],user = info[3],password = info[4])
    UNIT = 0x01
    for i in machines:
        sql = "INSERT INTO i ('Time', 'HR_SYSTEM_STATE','HR_LAST_FREEZE_TIME','HR_LAST_HARVEST_TIME','HR_WATER_FILL_TIME','HR_T1_TEMPERATURE','HR_T3_TEMPERATURE','HR_T2_TEMPERATURE','HR_T4_TEMPERATURE','HR_WLP_STATE_HIGH','HR_WLP_STATE_LOW','HR_WATER_CONDUCTIVITY','HR_ITP_STATE','HR_ITP_FFT_50HZ','HR_ITP_THRESHOLD_50HZ','HR_ITP_FFT_100HZ','HR_ITP_THRESHOLD_100HZ','HR_ITP_FFT_150HZ','HR_ITP_THRESHOLD_150HZ','HR_ITP_FFT_200HZ','HR_ITP_THRESHOLD_200HZ','HR_ITP_FFT_60HZ','HR_ITP_THRESHOLD_60HZ','HR_ITP_FFT_120HZ','HR_ITP_THRESHOLD_120HZ','HR_ITP_FFT_180HZ','HR_ITP_THRESHOLD_180HZ','HR_ITP_FFT_240HZ','HR_ITP_THRESHOLD_240HZ','HR_LEFT_CURTAIN_SW_STATE','HR_RIGHT_CURTAIN_SW_STATE)','HR_BIN_TEMPERATURE1','HR_BIN_TEMPERATURE2','HR_BIN_TEMPERATURE3','HR_FFT_6MIN_AVERAGE','HR_HPCO_STATE','HR_LPCO_STATE','HR_HPCO_COUNT_24HOURS','HR_LPCO_COUNT_24HOURS','HR_SAFETY_LIMIT_1','HR_SAFETY_LIMIT_2','HR_SOFTWARE_VER_MAJOR','HR_SOFTWARE_VER_MINOR','HR_DISPLAY_SOFTWARE_VER_MAJOR','HR_DISPLAY_SOFTWARE_VER_MINOR','HR_BIN_LEVEL_SETTING','HR_BIN_LEVEL_RUN_ENABLE','HR_ICE_CLARITY_ENABLE','HR_WATER_MISER_ENABLE','HR_AIR_FILTER_MINDER_ENABLE','HR_AIR_FILTER_INTERVAL','HR_CLEAN_MINDER_ENABLE','HR_CLEAN_MINDER_INTERVAL','HR_WATER_FILTER_SETTING','HR_WATER_FILTER_INTERVAL','HR_CLEAN_CYCLES_PER_24HOURS','HR_DATE_FORMAT_SETTING','HR_TIME_FORMAT_SETTING','HR_RESET_REGISTER','HR_LIFETIME_CLEAN_CYCLES','HR_SELF_CLEAN_INTERVAL','SIGNATURE_BYTE_ADDRESS','HR_MODEL_NUM_CHAR_1','HR_MODEL_NUM_CHAR_2','HR_MODEL_NUM_CHAR_3','HR_MODEL_NUM_CHAR_4','HR_MODEL_NUM_CHAR_5','HR_MODEL_NUM_CHAR_6','HR_MODEL_NUM_CHAR_7','HR_MODEL_NUM_CHAR_8','HR_MODEL_NUM_CHAR_9','HR_MODEL_NUM_CHAR_10','HR_MODEL_NUM_CHAR_11','HR_SERIAL_NUM_CHAR_1','HR_SERIAL_NUM_CHAR_2','HR_SERIAL_NUM_CHAR_3','HR_SERIAL_NUM_CHAR_4','HR_SERIAL_NUM_CHAR_5','HR_SERIAL_NUM_CHAR_6','HR_SERIAL_NUM_CHAR_7','HR_SERIAL_NUM_CHAR_8','HR_SERIAL_NUM_CHAR_9','HR_SERIAL_NUM_CHAR_10','HR_CONDENSER_SER_NUM_CHAR_1','HR_CONDENSER_SER_NUM_CHAR_2','HR_CONDENSER_SER_NUM_CHAR_3','HR_CONDENSER_SER_NUM_CHAR_4','HR_CONDENSER_SER_NUM_CHAR_5','HR_CONDENSER_SER_NUM_CHAR_6','HR_CONDENSER_SER_NUM_CHAR_7','HR_CONDENSER_SER_NUM_CHAR_8','HR_CONDENSER_SER_NUM_CHAR_9','HR_CONDENSER_SER_NUM_CHAR_10','HR_MACHINE_MANUFACTURER_SEC_HIGH','HR_MACHINE_MANUFACTURER_SEC_LOW','HR_PCB_MANUFACTURER_SEC_HIGH','HR_PCB_MANUFACTURER_SEC_LOW','HR_WARRANTY_TIME_REMAINING_DAYS','HR_CAPACITY_90_70','HR_SLAB_WEIGHT_ONES','HR_SLAB_WEIGHT_THOUSANDTHS','HR_GALLONS_WATER_PER_CYCLE_ONES','HR_GALLONS_WATER_PER_CYCLE_THOUSANDTHS','HR_LIFETIME_RUNTIME_HIGH_BYTE','HR_LIFETIME_RUNTIME_LOW_BYTE','HR_LIFETIME_CYCLE_COUNT_HIGH_BYTE','HR_LIFETIME_CYCLE_COUNT_LOW_BYTE','HR_MIN_FREEZE_TIME_24HOURS','HR_MAX_FREEZE_TIME_24HOURS','HR_AVG_FREEZE_TIME_24HOURS','HR_MIN_HARVEST_TIME_24HOURS','HR_MAX_HARVEST_TIME_24HOURS','HR_AVG_HARVEST_TIME_24HOURS','HR_BIN_FULL_COUNT_24HOURS','HR_CYCLES_PER_24HOURS','HR_ICE_WEIGHT_24HOURS','HR_WATER_USE_24HOURS','HR_MIN_T1_TEMP_24HOURS','HR_MAX_T1_TEMP_24HOURS','HR_MIN_T2_TEMP_24HOURS','HR_MAX_T2_TEMP_24HOURS','HR_MIN_T3_TEMP_24HOURS','HR_MAX_T3_TEMP_24HOURS','HR_MIN_T4_TEMP_24HOURS','HR_MAX_T4_TEMP_24HOURS','HR_MIN_FREEZE_CYCLE_T1','HR_MIN_FREEZE_CYCLE_T2','HR_MIN_FREEZE_CYCLE_T3','HR_MIN_FREEZE_CYCLE_T4','HR_MAX_FREEZE_CYCLE_T1','HR_MAX_FREEZE_CYCLE_T2','HR_MAX_FREEZE_CYCLE_T3','HR_MAX_FREEZE_CYCLE_T4','HR_MIN_HARVEST_CYCLE_T1','HR_MIN_HARVEST_CYCLE_T2','HR_MIN_HARVEST_CYCLE_T3','HR_MIN_HARVEST_CYCLE_T4','HR_MAX_HARVEST_CYCLE_T1','HR_MAX_HARVEST_CYCLE_T2','HR_MAX_HARVEST_CYCLE_T3','HR_MAX_HARVEST_CYCLE_T4,'HR_E01_COUNT_HIGH_BYTE','HR_E01_COUNT_LOW_BYTE','HR_E01_TIMESTAMP_HIGH_BYTE','HR_E01_TIMESTAMP_LOW_BYTE','HR_E02_COUNT_HIGH_BYTE','HR_E02_COUNT_LOW_BYTE','HR_E02_TIMESTAMP_HIGH_BYTE','HR_E02_TIMESTAMP_LOW_BYTE','HR_E03_COUNT_HIGH_BYTE','HR_E03_COUNT_LOW_BYTE','HR_E03_TIMESTAMP_HIGH_BYTE','HR_E03_TIMESTAMP_LOW_BYTE','HR_E04_COUNT_HIGH_BYTE','HR_E04_COUNT_LOW_BYTE','HR_E04_TIMESTAMP_HIGH_BYTE','HR_E04_TIMESTAMP_LOW_BYTE','HR_E05_COUNT_HIGH_BYTE','HR_E05_COUNT_LOW_BYTE','HR_E05_TIMESTAMP_HIGH_BYTE','HR_E05_TIMESTAMP_LOW_BYTE','HR_E06_COUNT_HIGH_BYTE','HR_E06_COUNT_LOW_BYTE','HR_E06_TIMESTAMP_HIGH_BYTE','HR_E06_TIMESTAMP_LOW_BYTE','HR_E07_COUNT_HIGH_BYTE','HR_E07_COUNT_LOW_BYTE','HR_E07_TIMESTAMP_HIGH_BYTE','HR_E07_TIMESTAMP_LOW_BYTE','HR_E08_COUNT_HIGH_BYTE','HR_E08_COUNT_LOW_BYTE','HR_E08_TIMESTAMP_HIGH_BYTE','HR_E08_TIMESTAMP_LOW_BYTE','HR_E09_COUNT_HIGH_BYTE','HR_E09_COUNT_LOW_BYTE','HR_E09_TIMESTAMP_HIGH_BYTE','HR_E09_TIMESTAMP_LOW_BYTE','HR_E10_COUNT_HIGH_BYTE','HR_E10_COUNT_LOW_BYTE','HR_E10_TIMESTAMP_HIGH_BYTE','HR_E10_TIMESTAMP_LOW_BYTE','HR_E11_COUNT_HIGH_BYTE','HR_E11_COUNT_LOW_BYTE','HR_E11_TIMESTAMP_HIGH_BYTE','HR_E11_TIMESTAMP_LOW_BYTE','HR_E12_COUNT_HIGH_BYTE','HR_E12_COUNT_LOW_BYTE','HR_E12_TIMESTAMP_HIGH_BYTE','HR_E12_TIMESTAMP_LOW_BYTE','HR_E13_COUNT_HIGH_BYTE','HR_E13_COUNT_LOW_BYTE','HR_E13_TIMESTAMP_HIGH_BYTE','HR_E13_TIMESTAMP_LOW_BYTE','HR_E14_COUNT_HIGH_BYTE','HR_E14_COUNT_LOW_BYTE','HR_E14_TIMESTAMP_HIGH_BYTE','HR_E14_TIMESTAMP_LOW_BYTE','HR_E15_COUNT_HIGH_BYTE','HR_E15_COUNT_LOW_BYTE','HR_E15_TIMESTAMP_HIGH_BYTE','HR_E15_TIMESTAMP_LOW_BYTE','HR_E16_COUNT_HIGH_BYTE','HR_E16_COUNT_LOW_BYTE','HR_E16_TIMESTAMP_HIGH_BYTE','HR_E16_TIMESTAMP_LOW_BYTE','HR_E17_COUNT_HIGH_BYTE','HR_E17_COUNT_LOW_BYTE','HR_E17_TIMESTAMP_HIGH_BYTE','HR_E17_TIMESTAMP_LOW_BYTE','HR_E18_COUNT_HIGH_BYTE','HR_E18_COUNT_LOW_BYTE','HR_E18_TIMESTAMP_HIGH_BYTE','HR_E18_TIMESTAMP_LOW_BYTE','HR_E19_COUNT_HIGH_BYTE','HR_E19_COUNT_LOW_BYTE','HR_E19_TIMESTAMP_HIGH_BYTE','HR_E19_TIMESTAMP_LOW_BYTE','HR_E20_COUNT_HIGH_BYTE','HR_E20_COUNT_LOW_BYTE','HR_E20_TIMESTAMP_HIGH_BYTE','HR_E20_TIMESTAMP_LOW_BYTE','HR_E21_COUNT_HIGH_BYTE','HR_E21_COUNT_LOW_BYTE','HR_E21_TIMESTAMP_HIGH_BYTE','HR_E21_TIMESTAMP_LOW_BYTE','HR_E22_COUNT_HIGH_BYTE','HR_E22_COUNT_LOW_BYTE','HR_E22_TIMESTAMP_HIGH_BYTE','HR_E22_TIMESTAMP_LOW_BYTE','HR_E23_COUNT_HIGH_BYTE','HR_E23_COUNT_LOW_BYTE','HR_E23_TIMESTAMP_HIGH_BYTE','HR_E23_TIMESTAMP_LOW_BYTE','HR_E24_COUNT_HIGH_BYTE','HR_E24_COUNT_LOW_BYTE','HR_E24_TIMESTAMP_HIGH_BYTE','HR_E24_TIMESTAMP_LOW_BYTE','HR_E25_COUNT_HIGH_BYTE','HR_E25_COUNT_LOW_BYTE','HR_E25_TIMESTAMP_HIGH_BYTE','HR_E25_TIMESTAMP_LOW_BYTE','HR_E26_COUNT_HIGH_BYTE','HR_E26_TIMESTAMP_HIGH_BYTE','HR_E26_TIMESTAMP_LOW_BYTE','HR_E27_COUNT_HIGH_BYTE','HR_E27_COUNT_LOW_BYTE','HR_E27_TIMESTAMP_HIGH_BYTE','HR_E27_TIMESTAMP_LOW_BYTE','HR_E28_COUNT_HIGH_BYTE','HR_E28_COUNT_LOW_BYTE','HR_E28_TIMESTAMP_HIGH_BYTE','HR_E28_TIMESTAMP_LOW_BYTE','HR_E29_COUNT_HIGH_BYTE','HR_E29_COUNT_LOW_BYTE','HR_E29_TIMESTAMP_HIGH_BYTE','HR_E29_TIMESTAMP_LOW_BYTE','HR_E30_COUNT_HIGH_BYTE','HR_E30_COUNT_LOW_BYTE','HR_E30_TIMESTAMP_HIGH_BYTE','HR_E30_TIMESTAMP_LOW_BYTE','HR_E31_COUNT_HIGH_BYTE','HR_E31_COUNT_LOW_BYTE','HR_E31_TIMESTAMP_HIGH_BYTE','HR_E31_TIMESTAMP_LOW_BYTE','HR_E32_COUNT_HIGH_BYTE','HR_E32_COUNT_LOW_BYTE','HR_E32_TIMESTAMP_HIGH_BYTE','HR_E32_TIMESTAMP_LOW_BYTE','HR_E33_COUNT_HIGH_BYTE','HR_E33_COUNT_LOW_BYTE','HR_E33_TIMESTAMP_HIGH_BYTE','HR_E33_TIMESTAMP_LOW_BYTE','HR_E34_COUNT_HIGH_BYTE','HR_E34_COUNT_LOW_BYTE','HR_E34_TIMESTAMP_HIGH_BYTE','HR_E34_TIMESTAMP_LOW_BYTE','HR_E35_COUNT_HIGH_BYTE','HR_E35_COUNT_LOW_BYTE','HR_E35_TIMESTAMP_HIGH_BYTE','HR_E35_TIMESTAMP_LOW_BYTE','HR_E36_COUNT_HIGH_BYTE','HR_E36_COUNT_LOW_BYTE','HR_E36_TIMESTAMP_HIGH_BYTE','HR_E36_TIMESTAMP_LOW_BYTE','HR_E37_COUNT_HIGH_BYTE','HR_E37_COUNT_LOW_BYTE','HR_E37_TIMESTAMP_HIGH_BYTE','HR_E37_TIMESTAMP_LOW_BYTE','HR_E38_COUNT_HIGH_BYTE','HR_E38_COUNT_LOW_BYTE','HR_E38_TIMESTAMP_HIGH_BYTE','HR_E38_TIMESTAMP_LOW_BYTE','HR_PROGRAM_MODE_ENABLE','HR_LANGUAGE','HR_DAYLIGHT_SAVINGS','HR_UNITS_TEMPERATURE','HR_UNITS_WEIGHTS','HR_UNITS_OF_VOLUME','HR_LCD_BRIGHTNESS','HR_SCREEN_SAVER','HR_AUCS_ENABLE','HR_AUCS_INTERVAL','HR_WATER_FILTER_TYPE','HR_IONIC_MINDER','HR_ON_TIME_1','HR_ON_TIME_2','HR_ON_TIME_3','HR_ON_TIME_4','HR_ON_TIME_5','HR_ON_TIME_6','HR_ON_TIME_7','HR_OFF_TIME_1','HR_OFF_TIME_2','HR_OFF_TIME_3','HR_OFF_TIME_4','HR_OFF_TIME_5','HR_OFF_TIME_6','HR_OFF_TIME_7','HR_ICE_MAKE_ON_OFF','HR_MANUAL_HARVEST','HR_CLEAN_CYCLE','HR_PROGRAM_BYPASS','HR_ACTIVATION_YEAR','HR_ACTIVATION_MONTH','HR_ACTIVATION_DAY','HR_MCC_AUTO_ICE_STATE','HR_LUMINICE1','HR_LUMINICE2','HR_AUCS_PRESENT','HR_T6_PRESENT','HR_T7_PRESENT','HR_AUCS_CLEAN_SUBSTATE','HR_MCC_CLEAN_SUBSTATE','HR_AUCS_TIMER','HR_MCC_TIMER','HR_READ_SERVICE_DATA_DAY1','HR_READ_SERVICE_DATA_DAY2','HR_READ_SERVICE_DATA_DAY3','HR_READ_SERVICE_DATA_DAY4','HR_READ_SERVICE_DATA_DAY5','HR_READ_OLD_FREEZE_MIN_T1','HR_READ_OLD_FREEZE_MIN_T2','HR_READ_OLD_FREEZE_MIN_T3','HR_READ_OLD_FREEZE_MIN_T4','HR_READ_OLD_FREEZE_MAX_T1','HR_READ_OLD_FREEZE_MAX_T2','HR_READ_OLD_FREEZE_MAX_T3','HR_READ_OLD_FREEZE_MAX_T4','HR_READ_OLD_HARVEST_MIN_T1','HR_READ_OLD_HARVEST_MIN_T2','HR_READ_OLD_HARVEST_MIN_T3','HR_READ_OLD_HARVEST_MIN_T4','HR_READ_OLD_HARVEST_MAX_T1','HR_READ_OLD_HARVEST_MAX_T2','HR_READ_OLD_HARVEST_MAX_T3','HR_READ_OLD_HARVEST_MAX_T4','HR_READ_OLD_RUN_TIME_24HRS','HR_READ_OLD_ICE_WEIGHT_24HRS','HR_READ_OLD_ICE_CYCLE_CNT_24HRS','HR_READ_OLD_POTABLE_H2O_24HRS','HR_READ_OLD_CLEAN_CYCLES_24HRS','HR_SET_MINDER_TIME_AIR_FILTER','HR_SET_MINDER_TIME_WATER_FILTER','HR_SET_MINDER_TIME_IONIC','HR_SET_MINDER_TIME_CLEAN','HR_SET_MINDER_TIME_AUCS_CLEAN','HR_SET_MINDER_FILTER_GALLONS','HR_SET_MINDER_SANITIZE','HR_SANITIZE_MINDER_ENABLE','HR_SANITIZE_MINDER_INTERVAL','HR_RESET_FACTORY_DEFAULTS','HR_PURGE_TIME','HR_ABORT_MCC','HR_ICE_USAGE_DAY1','HR_ICE_USAGE_DAY2','HR_ICE_USAGE_DAY3','HR_ICE_USAGE_DAY4','HR_ICE_USAGE_DAY5','HR_ICE_USAGE_DAY6','HR_ICE_USAGE_DAY7','HR_POTABLE_DAY1','HR_POTABLE_DAY2','HR_POTABLE_DAY3','HR_POTABLE_DAY4','HR_POTABLE_DAY5','HR_CALC_KW_DAY1','HR_CALC_KW_DAY2','HR_CALC_KW_DAY3','HR_CALC_KW_DAY4','HR_CALC_KW_DAY5','HR_UPDATE_FILE_SIZE','HR_FILE_SIZE_HI_FW','HR_FILE_SIZE_LO_FW','HR_ICE_PRODUCTION_DAY1','HR_ICE_PRODUCTION_DAY2','HR_ICE_PRODUCTION_DAY3','HR_ICE_PRODUCTION_DAY4','HR_ICE_PRODUCTION_DAY5','HR_PROCESS_PERCENT','HR_MIN_HARVEST_TIMESTAMP_SEC_HIGH','HR_MIN_HARVEST_TIMESTAMP_SEC_LOW','HR_MAX_HARVEST_TIMESTAMP_SEC_HIGH','HR_MAX_HARVEST_TIMESTAMP_SEC_LOW','HR_MIN_FREEZE_TIMESTAMP_SEC_HIGH','HR_MIN_FREEZE_TIMESTAMP_SEC_LOW','HR_MAX_FREEZE_TIMESTAMP_SEC_HIGH','HR_MAX_FREEZE_TIMESTAMP_SEC_LOW','HR_CLEAR_ALL_ALERTS','HR_SET_ALERT','HR_CLEAR_ALERT','HR_FORCE_AUCS_PUMP','HR_RELAY_OUTPUT_STATUS','HR_LIFETIME_POTABLE','HR_IS_MODEL_NUM_VALID','HR_LUMINICE_UNIT_STATUS','HR_UI_FILE_EXIST_FLAGS','LOAD_FIRMWARE','HR_MAILBOX_FLAGS','HR_DISPLAY_COMM_STATUS','HR_WIZARD_STATUS','HR_DISPLAY_SOFTWARE_VER_SUB_MINOR','HR_CB_SELF_CHECK,HR_ANY_ALERTS','HR_SERVICE_RELAY_TEST','HR_VERIFY_BOOTLOAD_FILES_IN_USB','HR_READ_SERVICE_DATA_DAY6','HR_READ_SERVICE_DATA_DAY7','HR_POTABLE_DAY6','HR_POTABLE_DAY7','HR_CALC_KW_DAY6','HR_CALC_KW_DAY7','HR_ICE_PRODUCTION_DAY6','HR_ICE_PRODUCTION_DAY7','HR_PROGRAM_MODE_TIME_MIN_LEFT','HR_OLD_DATA_TIME_STAMP_DAY1_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY1_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY2_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY2_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY3_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY3_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY4_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY4_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY5_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY5_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY6_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY6_LO_WORD','HR_OLD_DATA_TIME_STAMP_DAY7_HI_WORD','HR_OLD_DATA_TIME_STAMP_DAY7_LO_WORD','HR_ELAPSED_TIME_SECONDS','HR_OLD_MIN_HARVEST_TIMESTAMP_SEC_HIGH','HR_OLD_MIN_HARVEST_TIMESTAMP_SEC_LOW','HR_OLD_MAX_HARVEST_TIMESTAMP_SEC_HIGH','HR_OLD_MAX_HARVEST_TIMESTAMP_SEC_LOW','HR_OLD_MIN_FREEZE_TIMESTAMP_SEC_HIGH','HR_OLD_MIN_FREEZE_TIMESTAMP_SEC_LOW','HR_OLD_MAX_FREEZE_TIMESTAMP_SEC_HIGH','HR_OLD_MAX_FREEZE_TIMESTAMP_SEC_LOW','HR_OLD_MIN_FREEZE_TIME_24HOURS','HR_OLD_MAX_FREEZE_TIME_24HOURS','HR_OLD_MIN_HARVEST_TIME_24HOURS','HR_OLD_MAX_HARVEST_TIME_24HOURS','HR_DUMP_TIME','HR_ITP_VIB_ENABLE','HR_ITP_FFT_1KHZ','HR_1KHZ_THRESHOLD','HR_FREQ_REG_1','HR_FREQ_REG_2','HR_FREQ_REG_3','HR_FREQ_REG_4','HR_FREQ_REG_5','HR_FREQ_REG_6','HR_FREQ_REG_7','HR_FREQ_REG_8','HR_FREQ_REG_9','HR_FREQ_REG_10','HR_ACOUSTIC_ACTUATOR_CYCLE_COUNTS','HR_ACOUSTIC_ACTUATOR_LIFETIME_COUNTS','HR_FREEZE_IN_CHECK_FAIL_COUNTS','HR_THAW_BYPASS_VARIABLE','HR_FREEZE_TIME_20_SMPL_MEAN','HR_FREEZE_TIME_20_SMPL_MEDIAN','HR_FREEZE_TIME_20_SMPL_STD_DEV','HR_FREEZE_TIME_20_SMPL_RANGE','HR_TARGET_FREEZE_TIME_PREDICTION','HR_NORMALITY_q','HR_ACTIVE_SENSE_ENABLE_STATUS','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_CNT_HIGH_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_CNT_LOW_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_TIMESTAMP_HIGH_BYTE','HR_ACTIVE_SENSE_LONG_FREEZE_ERROR_TIMESTAMP_LOW_BYTE','HR_FREEZE_TIME1','HR_FREEZE_TIME2','HR_FREEZE_TIME3','HR_FREEZE_TIME4','HR_FREEZE_TIME5','HR_FREEZE_TIME6','HR_FREEZE_TIME7','HR_FREEZE_TIME8','HR_FREEZE_TIME9','HR_FREEZE_TIME10','HR_FREEZE_TIME11','HR_FREEZE_TIME12','HR_FREEZE_TIME13','HR_FREEZE_TIME14','HR_FREEZE_TIME15','HR_FREEZE_TIME16','HR_FREEZE_TIME17','HR_FREEZE_TIME18','HR_FREEZE_TIME19','HR_FREEZE_TIME20') VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"
        client = ModbusClient(mesthod = 'tcp', host = test, port = 8899)
        time_string = time.strftime("%m/%d/%Y %H:%M.%S")
        c = conn.cursor()
        data = []
        data.append(time_string)
        for i in regiserMap:
            data.append(client.read_holding_registers(i,1,unit = UNIT).registers)
        c.execute(sql, data)
    conn.commit()
    conn.close()
    pass
create_machine_table('1120179759',0)