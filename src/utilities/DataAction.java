package utilities;

public enum DataAction {
    IMPORT,SAVE,BACKUP,RESTORE,CLEAR;
    @Override
    public String toString() {
        switch (DataAction.this){
            case IMPORT : return "Import Data Text";
            case SAVE: return "Save Data";
            case BACKUP: return "Backup Data";
            case RESTORE: return "Restore Data";
            case CLEAR: return "Clear Data";
            default: return null;
            }
    }
}
