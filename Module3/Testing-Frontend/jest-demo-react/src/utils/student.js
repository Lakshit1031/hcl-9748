export const isEligible = (attendance) => {

    if (attendance < 0 || attendance > 100) {
        throw new Error("Invalid attendance percentage");
    }

    if (attendance >= 75) {
        return true;
    }

    return false;
};